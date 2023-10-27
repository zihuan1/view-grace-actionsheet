package com.zihuan.view.actionsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.zihuan.view.actionsheet.DefViewAdapter.MyHolder
import com.zihuan.view.actionsheet.listener.BottomSheetItemListener

/**
 * @author zihuan
 */
class DefViewAdapter(any: Any) : Adapter<MyHolder>() {
    private val listModel = ArrayList<String>()
    //    自动实现点击
    var mListener: BottomSheetItemListener? =
        if (any is BottomSheetItemListener) any else null

    /**
     * 设置监听
     */
    fun setListener(listener: BottomSheetItemListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.sheet_item_layout, viewGroup, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tvName.text = listModel[position]
        holder.itemView.setOnClickListener {
            mListener?.onSheetItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return listModel.size
    }

    fun update(modelArrayList: List<String>) {
        listModel.clear()
        listModel.addAll(modelArrayList)
        notifyDataSetChanged()
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
    }
}