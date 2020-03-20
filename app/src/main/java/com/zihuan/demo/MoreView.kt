package com.zihuan.demo

import android.content.Context
import android.view.View
import com.zihuan.view.actionsheet.BaseActionSheet
import com.zihuan.view.actionsheet.BaseActionView

 class MoreView : BaseActionView {
     override fun getParentView()=mParentView


     constructor(context: Context) : super(context) {

    }

     lateinit var mParentView: BaseActionSheet<*>
    override fun setParentView(parentView: BaseActionSheet<*>) {
        mParentView=parentView
    }

     override fun initView(view: View) {
     }

     override fun getLayoutId()=R.layout.coustom_layout

 }