package com.zihuan.view.actionsheet

import android.content.Context
import android.widget.FrameLayout

abstract class BaseActionView(context: Context) : FrameLayout(context) {
    abstract fun setParentView(parentView: BaseActionSheet<*>)
}