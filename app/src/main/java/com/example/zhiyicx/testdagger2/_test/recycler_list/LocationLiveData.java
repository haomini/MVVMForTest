package com.example.zhiyicx.testdagger2._test.recycler_list;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/30
 * @Contact 605626708@qq.com
 */

public class LocationLiveData extends LiveData<Location> {

    private final static Object mDataLock = new Object();

    private LocationManager mLocationManager;

    private static volatile LocationLiveData INSTANCE;

    private LocationLiveData(Context context) {
        mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public static LocationLiveData getItstance(Context context) {
        synchronized (mDataLock) {
            if (INSTANCE == null) {
                INSTANCE = new LocationLiveData(context);
            }
        }
        return INSTANCE;
    }

    private LocationListener listener = new SimpleLocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            super.onLocationChanged(location);
            setValue(location);
        }
    };

    /**
     * Called when the number of active observers change to 1 from 0.
     * <p>
     * This callback can be used to know that this LiveData is being used thus should be kept
     * up to date.
     */
    @Override
    protected void onActive() {
        super.onActive();

        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
    }

    /**
     * Called when the number of active observers change from 1 to 0.
     * <p>
     * This does not mean that there are no observers left, there may still be observers but their
     * lifecycle states aren't {@link Lifecycle.State#STARTED} or {@link Lifecycle.State#RESUMED}
     * (like an Activity in the back stack).
     * <p>
     * You can check if there are observers via {@link #hasObservers()}.
     */
    @Override
    protected void onInactive() {
        super.onInactive();
    }

    private class SimpleLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
