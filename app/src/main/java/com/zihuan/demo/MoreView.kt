package com.zihuan.demo

import android.content.Context
import android.util.Log
import android.view.View
import com.zihuan.view.actionsheet.ActionSheetStateListener
import com.zihuan.view.actionsheet.BaseActionSheet
import com.zihuan.view.actionsheet.BaseActionView

class MoreView : BaseActionView, ActionSheetStateListener {


    constructor(context: Context,parentView: BaseActionSheet<*>) : super(context,parentView)


    override fun initView(view: View) {
        setStateListener(this)
//        parentView.touchOutside(false)
    }

    override fun getLayoutId() = R.layout.coustom_layout
    override fun onDismiss() {
        Log.e("隐藏","隐藏")
    }

    override fun onShow() {
        Log.e("隐藏","显示")
    }

}