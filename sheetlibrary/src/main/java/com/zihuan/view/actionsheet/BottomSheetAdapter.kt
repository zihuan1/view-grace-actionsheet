package com.zihuan.view.actionsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.zihuan.view.actionsheet.BottomSheetAdapter.MyHolder

/**
 * @author zihuan
 */
class BottomSheetAdapter : Adapter<MyHolder>() {
    private val listModel = ArrayList<String>()
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.sheet_item_layout, viewGroup, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tvName.text = listModel[position]
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