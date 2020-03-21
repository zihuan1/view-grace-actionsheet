package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DefaultActionView(context: Context) : BaseActionView(context) {
    private lateinit var tvDismiss: TextView
    private lateinit var mBottomAdapter: DefViewAdapter
    private var mDismissListener: ActionSheetDismissListener? = null
    private lateinit var mParentView: BaseActionSheet<*>

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

    /**
     * 设置Item监听
     */
    fun setItemListener(listener: ActionSheetListener) {
        mBottomAdapter.setListener(listener)
    }

    /**
     * 设置隐藏监听
     */
    fun setDismissListener(listener: ActionSheetDismissListener) {
        mDismissListener = listener
    }

    /**
     * 添加分割线
     */
    fun addDecoration(decor: RecyclerView.ItemDecoration) {
        recycleView.addItemDecoration(decor)
    }

    /**
     * 更新指定位置的数据
     */
    fun updatePositionData(position: Int, value: String) {
        dataList[position] = value
        mBottomAdapter.update(dataList)
    }

    fun update() {
        mBottomAdapter.notifyDataSetChanged()
    }

    override fun setParentView(parentView: BaseActionSheet<*>) {
        mParentView = parentView
        tvDismiss.setOnClickListener {
            mDismissListener?.onDismiss()
            parentView.dismiss()
        }
    }

    lateinit var recycleView: RecyclerView
    override fun getParentView() = mParentView

    override fun initView(view: View) {
        recycleView = view.findViewById(R.id.recycleView)
        tvDismiss = view.findViewById(R.id.tv_dismiss)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = layoutManager
        mBottomAdapter = DefViewAdapter(context)
        recycleView.adapter = mBottomAdapter
        if (context is ActionSheetDismissListener) {
            mDismissListener = context as ActionSheetDismissListener
        }
        dismissText?.let { tvDismiss.text = it }
        dismissTextColor?.let { tvDismiss.setTextColor(it) }
    }


    override fun getLayoutId() = R.layout.sheet_list_layout


}