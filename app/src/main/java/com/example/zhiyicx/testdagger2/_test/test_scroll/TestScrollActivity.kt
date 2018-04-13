package com.example.zhiyicx.testdagger2._test.test_scroll

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import com.example.zhiyicx.testdagger2.R
import kotlinx.android.synthetic.main.activity_test_scroll.*

class TestScrollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_scroll)

        myView.setOnTouchListener({ _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Log.e("test_down", ": " + event.x + " : "+event.rawX)
                }
                MotionEvent.ACTION_MOVE -> {
                    Log.e("test_move", ": " + event.x + " : "+event.rawX)
                }
                MotionEvent.ACTION_UP -> {
                    Log.e("test_up", ": " + event.x + " : "+event.rawX)
                }
                MotionEvent.ACTION_CANCEL -> {
                    Log.e("test_cancel", ": " + event.x + " : "+event.rawX)
                }
            }
            true
        })
    }
}
