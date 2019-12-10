package com.zihuan.view.actionsheet

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class BottomSheetView private constructor(context: Context) : BaseActionSheet(context) {

    private var tvDismiss: TextView
    private var mBottomAdapter: BottomSheetAdapter
    private var mDismissListener: ActionSheetDismissListener? = null

    /**
     * 取消文字
     */
    var dismissText: String? = null
        set(value) {
            tvDismiss.text = value
        }
    /***
     * 字体颜色
     */
    var dismissTextColor: Int? = null
        set(value) {
            value?.let { tvDismiss.setTextColor(it) }
        }
    /**
     * 数据
     */
    var dataList = ArrayList<String>()
        set(value) {
            dataList.clear()
            dataList.addAll(value)
            mBottomAdapter.update(dataList)
        }


    fun setViewOnItemClick(onItemClick: ActionSheetListener) {
        mBottomAdapter.mListener = onItemClick
    }


    fun setTextColor(color: Int): BottomSheetView {
        tvDismiss.setTextColor(color)
        return this
    }

    companion object {
        private var sheetView: BottomSheetView? = null
        fun build(context: Context): BottomSheetView {
            if (null == sheetView || context != sheetView?.mContext) {
                sheetView = null
                sheetView = BottomSheetView(context)
            }
            return sheetView!!
        }
    }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.sheet_list_layout, null)
        val recycleView = view.findViewById<RecyclerView>(R.id.recycleView)
        tvDismiss = view.findViewById(R.id.tv_dismiss)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = layoutManager
        mBottomAdapter = BottomSheetAdapter(context)
        recycleView.adapter = mBottomAdapter
        setView(view)
        if (context is ActionSheetDismissListener) {
            mDismissListener = context
        }
        tvDismiss.setOnClickListener { dismiss() }
    }
}