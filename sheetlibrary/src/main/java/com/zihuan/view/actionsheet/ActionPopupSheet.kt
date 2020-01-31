package com.zihuan.view.actionsheet

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow

class ActionPopupSheet<T : BaseActionView>(
    private val context: Context,
    private val rootView: View
) : BaseActionSheet<T> {

    private var mPopupWindow = PopupWindow(context)
    private var mDefaultView: T? = null

    override fun dismiss() {
        if (mPopupWindow != null && mPopupWindow.isShowing) {
            mPopupWindow.dismiss()
        }
    }

    override fun show(xoff: Int, yoff: Int) {
        // 第一个参数是要将PopupWindow放到的View，第二个参数是位置，第三第四是偏移值
//        mPopupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0)
        mPopupWindow.showAsDropDown(rootView, xoff, yoff)
        // 适配 android 7.0
//            val point = IntArray(2)
//            rootView.getLocationInWindow(point)
//            mPopupWindow.showAtLocation(
//                (context as Activity).window.decorView,
//                Gravity.NO_GRAVITY,
//                0,
//                point[1] + rootView.height
//            )
    }


    override fun getView() = mDefaultView!!
    override fun setView(view: T, init: T.() -> Unit) {
        mDefaultView = view
        mPopupWindow.setBackgroundDrawable(context.resources.getDrawable(R.color.action_sheet_transparent))
        mPopupWindow.width = WindowManager.LayoutParams.MATCH_PARENT
        mPopupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
        mPopupWindow.isTouchable = true
        mPopupWindow.isFocusable = true
        mPopupWindow.isOutsideTouchable = true
        mPopupWindow.contentView = mDefaultView
        mPopupWindow.contentView.setOnTouchListener { v, event ->
            mPopupWindow.isFocusable = false
            mPopupWindow.dismiss()
            true
        }
        init(view)
        view.setParentView(this)
    }
}