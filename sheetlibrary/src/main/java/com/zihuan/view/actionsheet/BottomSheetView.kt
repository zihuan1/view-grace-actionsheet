package com.zihuan.view.actionsheet

import android.app.Activity
import android.content.Context
import android.graphics.Color
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
        //RecyclerView部分透明度 整体蒙层设置不是这
        mSheetDialog.delegate.findViewById<View>(R.id.design_bottom_sheet)
                ?.setBackgroundColor(Color.parseColor("#00000000"))
        init(getView())
    }

    override fun getView() = mDefaultView!!

    override fun touchOutside(outside: Boolean) {
        mSheetDialog.setCanceledOnTouchOutside(outside)
    }

}