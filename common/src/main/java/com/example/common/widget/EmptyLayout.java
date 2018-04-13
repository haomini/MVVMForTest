package com.example.common.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.widget.FrameLayout;

import com.example.common.R;
import com.example.common.databind.command.ReplyProcess;
import com.example.common.databinding.EmptyLayoutBinding;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/6
 * @Contact 605626708@qq.com
 */

public class EmptyLayout extends FrameLayout {

    public static final int LOADING = 0;
    public static final int HIDE_LAYOUT = 1;
    public static final int NODATA = 2;
    public static final int ERROR = 3;

    @IntDef({LOADING, HIDE_LAYOUT, NODATA, ERROR})
    public @interface EMPTY_STATE {

    }

    public final ObservableField<Integer> state = new ObservableField<>();
    public final ObservableBoolean show = new ObservableBoolean(false);
    public final ObservableBoolean loading = new ObservableBoolean(false);

    protected EmptyLayoutBinding mEmptyLayoutBinding;

    public EmptyLayout(@NonNull Context context) {
        this(context, null);
    }

    public EmptyLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmptyLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mEmptyLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.empty_layout, this, true);
        mEmptyLayoutBinding.setElVm(this);
        setOnClickListener(v -> {
            if ((state.get() == NODATA || state.get() == ERROR) && onEmptyClicked != null)
                onEmptyClicked.run();
        });
        VelocityTracker.obtain().clear();
    }

    public ReplyProcess onEmptyClicked;

    public void setOnEmptyClicked(ReplyProcess onEmptyClicked) {
        this.onEmptyClicked = onEmptyClicked;
    }

    public void setState(@EMPTY_STATE int state) {
        this.state.set(state);
        switch (state) {
            case LOADING:
                setVisibility(VISIBLE);
                show.set(false);
                loading.set(true);
                break;
            case HIDE_LAYOUT:
                setVisibility(GONE);
                loading.set(false);
                break;
            case NODATA:
                setVisibility(VISIBLE);
                show.set(true);
                loading.set(false);
                break;
            case ERROR:
                setVisibility(VISIBLE);
                show.set(true);
                loading.set(false);
                break;
        }
    }
}
