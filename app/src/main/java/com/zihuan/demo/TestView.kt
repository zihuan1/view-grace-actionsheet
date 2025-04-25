package com.zihuan.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.zihuan.view.actionsheet.BaseSheetContentView
import com.zihuan.view.actionsheet.BaseSheetLayout

class TestView : BaseSheetContentView {

    constructor(context: Context, parentView: BaseSheetLayout<*>) : super(context, parentView) {
        val view = LayoutInflater.from(context).inflate(R.layout.coustom_layout, this, false)
        createLayoutCustom(view)
    }

    override fun initView(view: View) {
    }

}