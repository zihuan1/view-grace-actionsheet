package com.zihuan.view.actionsheet

import android.app.Activity
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class BottomSheetView(context: Activity) : BaseBottomSheet(context!!) {
    internal var tvDismiss: TextView
    internal var mBottomAdapter: BottomSheetAdapter
    internal var mStrList: MutableList<String> = ArrayList()
    fun setViewOnItemClick() { //        mBottomAdapter.setOnItemClick(viewOnItemClick);
    }

    /**
     * 设置数据
     *
     * @param data
     * @return
     */
    fun setData(vararg data: String?): BottomSheetView {
        if (data != null) {
            mStrList.clear()
            mStrList.addAll(Arrays.asList<String>(*data))
            mBottomAdapter.update(mStrList)
        }
        return this
    }

    /***
     * 显示
     * @return
     */
    fun showDialog(): BottomSheetView {
        showView()
        return this
    }

    /***
     * 隐藏
     * @return
     */
    fun dismissDialog(): BottomSheetView {
        super.dismissView()
        return this
    }

    /***
     * 取消文字
     * @param text
     * @return
     */
    fun setDismissText(text: String?): BottomSheetView {
        tvDismiss.text = text
        return this
    }

    /***
     * 字体颜色
     * @param color
     * @return
     */
    fun setTextColor(color: Int): BottomSheetView {
        tvDismiss.setTextColor(color)
        return this
    }

    companion object {
        private var sheetView: BottomSheetView? = null
        fun build(context: Activity): BottomSheetView {
            if (null == sheetView || context != sheetView!!.mActivity) {
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
        mBottomAdapter = BottomSheetAdapter()
        recycleView.adapter = mBottomAdapter
        setView(view)
        tvDismiss.setOnClickListener { dismissDialog() }
    }
}