package com.zihuan.view.actionsheet

import android.app.Activity
import android.content.Context
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.zihuan.view.actionsheet.listener.BottomSheetDismissListener
import com.zihuan.view.actionsheet.listener.BottomSheetListener
import com.zihuan.view.actionsheet.listener.BottomSheetShowListener

class BottomSheetLayout<T : BaseSheetContentView>(private val context: Context) : BaseSheetLayout<T> {

    private var sheetDialog = BottomSheetDialog(context)
    private var contentView: T? = null
    private var listener: BottomSheetListener? = null
    private var showListener: BottomSheetShowListener? = null
    private var dismissListener: BottomSheetDismissListener? = null


    override fun show(xoff: Int, yoff: Int) {
        if (context is Activity && context.isFinishing && !sheetDialog.isShowing) return
        sheetDialog.show()
    }

    override fun dismiss() {
        if (context is Activity && context.isFinishing && sheetDialog.isShowing) return
        sheetDialog.dismiss()
    }

    override fun setView(view: T, init: T.() -> Unit) {
        contentView = view
        sheetDialog.setContentView(contentView)
        sheetDialog.setOnShowListener {
            listener?.onShow()
            showListener?.onShow()
        }
        sheetDialog.setOnDismissListener {
            listener?.onDismiss()
            dismissListener?.onDismiss()
        }

        //滑动层背景透明 整体蒙层设置不是这
//        mSheetDialog.delegate.findViewById<View>(R.id.design_bottom_sheet)
//            ?.setBackgroundColor(Color.TRANSPARENT)
        sheetDialog.window.findViewById<View>(R.id.design_bottom_sheet)
                .setBackgroundResource(android.R.color.transparent);
//        mSheetDialog.window.setBackgroundDrawableResource(android.R.color.transparent)
        init(getView())
    }

    override fun getView() = contentView!!

    override fun touchOutside(outside: Boolean): BottomSheetLayout<T> {
        sheetDialog.setCanceledOnTouchOutside(outside)
        return this
    }

    override fun getSheetDialog(): BottomSheetDialog {
        return sheetDialog
    }

    override fun setState(state: Int): BottomSheetLayout<T> {
        sheetDialog.behavior.state = state
        return this
    }

    override fun setHideable(state: Boolean): BaseSheetLayout<T> {
        sheetDialog.behavior.isHideable = state
        return this
    }

    override fun setPeekHeight(height: Int): BottomSheetLayout<T> {
        sheetDialog.behavior.peekHeight = height
        return this
    }

    override fun setDimAmount(amount: Float): BaseSheetLayout<T> {
        sheetDialog.window.setDimAmount(amount)
        return this
    }

    override fun setShowListener(listener: BottomSheetShowListener): BottomSheetLayout<T> {
        showListener = listener
        return this
    }

    override fun setDismissListener(listener: BottomSheetDismissListener): BottomSheetLayout<T>  {
        dismissListener = listener
        return this
    }

    override fun setStatusListener(listener: BottomSheetListener): BottomSheetLayout<T>  {
        this.listener = listener
        return this
    }
}