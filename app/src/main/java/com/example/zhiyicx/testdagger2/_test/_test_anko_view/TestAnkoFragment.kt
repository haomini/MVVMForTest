package com.example.zhiyicx.testdagger2._test._test_anko_view

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/1/17
 * @Contact 605626708@qq.com
 */
class TestAnkoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = TestAnkoFragmentUI().createView(AnkoContext.Companion.create(context!!, this))

}

class TestAnkoFragmentUI : AnkoComponent<TestAnkoFragment> {
    override fun createView(ui: AnkoContext<TestAnkoFragment>) = with(ui) {
        linearLayout {
            textView {
                text = "nishishui"
                textColor = Color.parseColor("#ffffff")
                onClick {
                    toast("woshiwo")
                }
            }
        }
    }
}