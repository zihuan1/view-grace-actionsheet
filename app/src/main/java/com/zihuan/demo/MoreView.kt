package com.zihuan.demo

import android.content.Context
import android.view.View
import com.zihuan.view.actionsheet.BaseActionSheet
import com.zihuan.view.actionsheet.BaseActionView

 class MoreView : BaseActionView {

    constructor(context: Context) : super(context) {

    }

    override fun setParentView(parentView: BaseActionSheet<*>) {

    }

     override fun initView(view: View) {
     }

     override fun getLayoutId()=R.layout.coustom_layout

 }