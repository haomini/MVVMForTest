package com.example.zhiyicx.testdagger2._test._test_top_change

import android.os.Bundle
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.zhiyicx.testdagger2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var height: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nes.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
            view.translationY = (scrollY * 2).toFloat()

            btn2.translationY = scrollY.toFloat() * 2 + scrollY / 10

            Log.e("height", "$height")
        })

        window.decorView.post {
            height = btn.height
        }
    }
}
