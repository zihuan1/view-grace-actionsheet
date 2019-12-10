//package com.zihuan.view.actionsheet
//
//import android.content.Context
//import android.view.Gravity
//import android.view.LayoutInflater
//import android.view.View
//import android.view.WindowManager
//import android.widget.PopupWindow
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import java.util.*
//
//class ActionDialogSheet(context: Context, rootView: View) : BaseActionSheet {
//    var mPopupWindow: PopupWindow?
//    var recycleView: RecyclerView
//    var tvDismiss: TextView
//    var mBottomAdapter: DefViewAdapter
//    var mFieldList: MutableList<String> = ArrayList()
//    private val mContext: Context
//    var showAsDropDown: View
//    fun setData(list: List<String>) {
//        mFieldList.addAll(list)
//        mBottomAdapter.update(mFieldList)
//    }
//
//    override fun dismiss() {
//        if (mPopupWindow != null && mPopupWindow!!.isShowing) {
//            mPopupWindow!!.dismiss()
//        }
//    }
//
//    override fun show() {
//        mPopupWindow!!.showAtLocation(showAsDropDown, Gravity.BOTTOM, 0, 0)
//    }
//
//    init {
//        val view =
//            LayoutInflater.from(context).inflate(R.layout.sheet_list_layout, null)
//        recycleView = view.findViewById(R.id.recycleView)
//        tvDismiss = view.findViewById(R.id.tv_dismiss)
//        showAsDropDown = rootView
//        mContext = context
//        mPopupWindow = PopupWindow(context)
//        //        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
//        mPopupWindow!!.width = WindowManager.LayoutParams.MATCH_PARENT
//        mPopupWindow!!.height = WindowManager.LayoutParams.MATCH_PARENT
//        mPopupWindow!!.isTouchable = true
//        mPopupWindow!!.isFocusable = true
//        mPopupWindow!!.isOutsideTouchable = true
//        mPopupWindow!!.contentView = view
//        // 第一个参数是要将PopupWindow放到的View，第二个参数是位置，第三第四是偏移值
//        mBottomAdapter = DefViewAdapter(context)
//        recycleView.adapter = mBottomAdapter
//        mPopupWindow!!.contentView.setOnTouchListener { v, event ->
//            mPopupWindow!!.isFocusable = false
//            mPopupWindow!!.dismiss()
//            true
//        }
//    }
//}