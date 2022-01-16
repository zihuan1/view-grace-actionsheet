package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import com.google.android.material.bottomsheet.BottomSheetDialog

class ActionPopupSheet<T : BaseActionView>(
    private val context: Context,
    private val rootView: View
) : BaseActionSheet<T> {

      var mPopupWindow = PopupWindow(context)
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
        mDefaultView?.listener?.onShow()
    }


    override fun getView() = mDefaultView!!
    override fun setView(view: T, init: T.() -> Unit) {
        mDefaultView = view
        mPopupWindow.setBackgroundDrawable(context.resources.getDrawable(R.color.action_sheet_transparent))
        mPopupWindow.width = WindowManager.LayoutParams.MATCH_PARENT
        mPopupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
        mPopupWindow.isTouchable = outside
        mPopupWindow.isFocusable = outside
        mPopupWindow.isOutsideTouchable = outside
        mPopupWindow.contentView = mDefaultView
        mPopupWindow.setOnDismissListener {
            mDefaultView?.listener?.onDismiss()
        }
        init(view)
    }

    private var outside = true
    override fun touchOutside(outside: Boolean) {
        this.outside = outside
    }

    override fun getSheetDialog() = mPopupWindow


}