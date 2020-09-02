package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View
import android.widget.FrameLayout

abstract class BaseActionView : FrameLayout {

    var parentView: BaseActionSheet<*>

    constructor(context: Context, parentView: BaseActionSheet<*>) : super(context) {
        this.parentView = parentView
        initView(View.inflate(context, getLayoutId(), this))
    }

    abstract fun initView(view: View)
    abstract fun getLayoutId(): Int

    var listener: ActionSheetStateListener? = null
    fun setStateListener(listener: ActionSheetStateListener) {
        this.listener = listener
    }

    fun show(xoff: Int = 0, yoff: Int = 0) {
        parentView.show(xoff, yoff)
    }

    fun dismiss() {
        parentView.dismiss()
    }


}