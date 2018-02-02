package com.example.zhiyicx.testdagger2._test._test_anko_view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout.VERTICAL
import org.jetbrains.anko.*


/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/1/17
 * @Contact 605626708@qq.com
 */
class TestAnkoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TestActivityUI().setContentView(this)

        supportFragmentManager.beginTransaction()
                .add(Ids.tv1, TestAnkoFragment())
                .commit()

    }
}

class TestActivityUI : AnkoComponent<TestAnkoActivity> {

    override fun createView(ui: AnkoContext<TestAnkoActivity>): View = ui.apply {
        linearLayout {
            orientation = VERTICAL
            lparams(matchParent, matchParent)
            fitsSystemWindows = true
            frameLayout {
                id = Ids.tv1
            }
        }
    }.view
}

private object Ids {
    val tv1 = 1
}