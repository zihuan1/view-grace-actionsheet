package com.zihuan.view.actionsheet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.zihuan.view.actionsheet.listener.BottomSheetDismissListener
import com.zihuan.view.actionsheet.listener.BottomSheetShowListener
import com.zihuan.view.actionsheet.listener.BottomSheetListener

abstract class BaseSheetContentView : FrameLayout {

    var parentView: BaseSheetLayout<*>

    constructor(context: Context, parentView: BaseSheetLayout<*>) : super(context) {
        this.parentView = parentView
        createLayoutForRes()?.let {
            initView(it)
        }
    }

    abstract fun initView(view: View)
    open fun getLayoutId(): Int {
        return 0
    }

    private fun createLayoutForRes(): View? {
        if (getLayoutId() == 0) return null
        val view = LayoutInflater.from(context).inflate(getLayoutId(), this, false)
        return view
    }

    fun createLayoutCustom(view: View) {
        addView(view)
        initView(view)
    }

    fun show(xOffset: Int = 0, yOffset: Int = 0) {
        parentView.show(xOffset, yOffset)
    }

    fun dismiss() {
        parentView.dismiss()
    }

}