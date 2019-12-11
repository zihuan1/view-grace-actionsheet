package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DefaultActionView : BaseActionView {

    private var tvDismiss: TextView
    private var mBottomAdapter: DefViewAdapter
    private var mDismissListener: ActionSheetDismissListener? = null

    /**
     * 取消文字
     */
    var dismissText: String? = null

    /***
     * 字体颜色
     */
    var dismissTextColor: Int? = null

    /**
     * 刷新数据
     */
    var dataList = ArrayList<String>()
        set(value) {
            dataList.clear()
            dataList.addAll(value)
            mBottomAdapter.update(dataList)
        }

    constructor(context: Context) : super(context) {
        val view = View.inflate(context, R.layout.sheet_list_layout, this)
        val recycleView = view.findViewById<RecyclerView>(R.id.recycleView)
        tvDismiss = view.findViewById(R.id.tv_dismiss)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = layoutManager
        mBottomAdapter = DefViewAdapter(context)
        recycleView.adapter = mBottomAdapter
        if (context is ActionSheetDismissListener) {
            mDismissListener = context
        }
        dismissText?.let { tvDismiss.text = it }
        dismissTextColor?.let { tvDismiss.setTextColor(it) }

    }

    override fun setParentView(parentView: BaseActionSheet<*>) {
        tvDismiss.setOnClickListener {
            mDismissListener?.onDismiss()
            parentView.dismiss()
        }
    }


}