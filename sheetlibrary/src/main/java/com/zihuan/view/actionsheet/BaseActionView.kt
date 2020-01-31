package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View
import android.widget.FrameLayout

abstract class BaseActionView : FrameLayout {

    constructor(context: Context) : super(context) {
        initView(View.inflate(context, getLayoutId(), this))
    }

    abstract fun setParentView(parentView: BaseActionSheet<*>)
    abstract fun initView(view: View)
    abstract fun getLayoutId(): Int

}