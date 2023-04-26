package com.zihuan.view.actionsheet

import android.app.Activity
import android.content.Context
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetView<T : BaseActionView>(private val context: Context) : BaseActionSheet<T> {


    private var mSheetDialog = BottomSheetDialog(context)
    private var mDefaultView: T? = null


    override fun show(xoff: Int, yoff: Int) {
        if (context is Activity && context.isFinishing && !mSheetDialog.isShowing) return
        mSheetDialog.show()
    }

    override fun dismiss() {
        if (context is Activity && context.isFinishing && mSheetDialog.isShowing) return
        mSheetDialog.dismiss()
    }

    override fun setView(view: T, init: T.() -> Unit) {
        mDefaultView = view
        mSheetDialog.setContentView(mDefaultView)
        //滑动层背景透明 整体蒙层设置不是这
//        mSheetDialog.delegate.findViewById<View>(R.id.design_bottom_sheet)
//            ?.setBackgroundColor(Color.TRANSPARENT)
        mSheetDialog.window.findViewById<View>(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
//        mSheetDialog.window.setBackgroundDrawableResource(android.R.color.transparent)
        init(getView())
    }

    override fun getView() = mDefaultView!!

    override fun touchOutside(outside: Boolean): BottomSheetView<T> {
        mSheetDialog.setCanceledOnTouchOutside(outside)
        return this
    }

    override fun getSheetDialog(): BottomSheetDialog {
        return mSheetDialog
    }

    override fun setState(state: Int): BottomSheetView<T> {
        mSheetDialog.behavior.state = state
        return this
    }

    override fun setHideable(state: Boolean): BaseActionSheet<T> {
        mSheetDialog.behavior.isHideable = state
        return this
    }

    override fun setPeekHeight(height: Int): BottomSheetView<T> {
        mSheetDialog.behavior.peekHeight = height
        return this
    }

    override fun setDimAmount(amount: Float): BaseActionSheet<T> {
        mSheetDialog.window.setDimAmount(amount)
         return  this
    }

}