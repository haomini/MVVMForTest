package com.example.zhiyicx.testdagger2._test._test_vp

import android.os.Build
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zhiyicx.testdagger2.R
import kotlinx.android.synthetic.main.activity_test_vp.*

class TestVpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_vp)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        vp1.adapter = MyAdapter()
        vp1.pageMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8.0F, resources.displayMetrics).toInt()
        vp1.setPageTransformer(true, MyZoomAnim())

        vp1.setCurrentItem(Short.MAX_VALUE / 2, false)
    }

    class MyAdapter : PagerAdapter() {
        override fun isViewFromObject(view: View, `object`: Any) = view == `object`

        override fun getCount() = Short.MAX_VALUE.toInt()

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(container.context).inflate(R.layout.page_item, container, false)
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View?)
        }

    }

    class MyZoomAnim : ViewPager.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            page.scaleY = 1.0F - 0.15F * Math.abs(position)
        }
    }
}
