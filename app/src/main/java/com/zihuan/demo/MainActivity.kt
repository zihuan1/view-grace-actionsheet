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
            //        //   1 推荐用法
            defSheetView {
                dataList = list
            }.show()
// //           2 自定义用法
//            zBottomSheetView(DefaultActionView(this)) {
//                dataList = list
//            }.show()
//            //3
//            val view = BottomSheetView<DefaultActionView>(this).apply {
//                var view = DefaultActionView(this@MainActivity)
//                view.setParentView(this)
//                setView(view)
//            }
//            zSheetView(view) {
//                dataList = list
//            }.show()
        }
        tv_.setOnClickListener {
//            it.defPopupView {
//                dataList = list
//            }.show()
//            自定义用法
            it.zPopupView(MoreView(this)) {
//                dataList = list
            }.show()
        }
        tv_3.setOnClickListener {
            it.defPopupView {
                dataList = list
            }.show(100,200)
        }
    }

    override fun onSheetItemClick(position: Int) {
        Toast.makeText(this, "位置$position", Toast.LENGTH_SHORT).show()
    }

    override fun onDismiss() {
        Toast.makeText(this, "取消了", Toast.LENGTH_SHORT).show()
    }

}
