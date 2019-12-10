package com.zihuan.view.actionsheet

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.collections.ArrayList

class BottomSheetView<T : ActionBaseView>(private val context: Context) :
    BaseActionSheet<T> {


//    companion object {

//        private var sheetView: BottomSheetView? = null
//        fun build(context: Context): BottomSheetView {
//            if (null == sheetView || context != sheetView?.context) {
//                sheetView = null
//                sheetView = BottomSheetView(context)
//            }
//            return sheetView!!
//        }
//    }

    private var mSheetDialog = BottomSheetDialog(context)
    private var mDefaultView: T? = null


    override fun show() {
        if (context is Activity && context.isFinishing && !mSheetDialog.isShowing) return
        mSheetDialog.show()
    }

    override fun dismiss() {
        if (context is Activity && context.isFinishing && mSheetDialog.isShowing) return
        mSheetDialog.dismiss()
    }

    override fun setView(view: T) {
        mDefaultView = view
        mSheetDialog.setContentView(mDefaultView)
        //RecyclerView部分透明度 整体蒙层设置不是这
        mSheetDialog.delegate.findViewById<View>(R.id.design_bottom_sheet)
            ?.setBackgroundColor(Color.parseColor("#00000000"))
    }

    override fun getView() = mDefaultView!!


}