package com.zihuan.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zihuan.view.actionsheet.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ActionSheetListener, ActionSheetDismissListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = ArrayList<String>()
        list.add("一")
        list.add("二")
        tv_1.setOnClickListener {
            defSheetView {
                dataList = list
            }.show()

//            zSheetView(BottomSheetView.build(this)) {
//                dataList = list
//            }.show()
        }
    }

    override fun onSheetItemClick(position: Int) {
        Toast.makeText(this, "位置$position", Toast.LENGTH_SHORT).show()
    }

    override fun onDismiss() {
        Toast.makeText(this, "取消了", Toast.LENGTH_SHORT).show()
    }

}
