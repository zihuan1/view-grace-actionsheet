package com.zihuan.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zihuan.view.actionsheet.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ActionSheetListener,
    ActionSheetStateListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = ArrayList<String>()
        list.add("一")
        list.add("二")
        //        //   1 推荐用法
        val sheet = defBottomSheetView {
            dataList = list
        }
        tv_1.setOnClickListener {

            //            sheet.getView().setItemListener(object : ActionSheetListener {
//                override fun onSheetItemClick(position: Int) {
//                    Toast.makeText(this@MainActivity, "asd位置$position", Toast.LENGTH_SHORT).show()
//                }
//            })
//            sheet.getView().setDismissListener(object :ActionSheetStateListener{
//                override fun onDismiss() {
//                    Toast.makeText(this@MainActivity, "取消了了了了", Toast.LENGTH_SHORT).show()
//                }
//            })
            sheet.getView()
                .addDecoration(RecycleViewDividerJava(this, LinearLayoutManager.VERTICAL))
            sheet.getView().setItemListener(ActionSheetListener { position ->
                Toast.makeText(this@MainActivity, "asd位置$position", Toast.LENGTH_SHORT).show()
                sheet.dismiss()
            })
            sheet.show()
        }

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
        tv_top.setOnClickListener {
            //            it.defPopupView {
//                dataList = list
//            }.show()
//            自定义用法
            it.sheetView<MoreView> {
                //                dataList = list

            }.show()
        }
        tv_bottom.setOnClickListener {
            it.defSheetView {
                dataList = list
            }.show(100, 200)
        }

    }

    override fun onSheetItemClick(position: Int) {
        Toast.makeText(this, "位置$position", Toast.LENGTH_SHORT).show()
    }

    override fun onDismiss() {
        Toast.makeText(this, "取消了", Toast.LENGTH_SHORT).show()
    }

    override fun onShow() {

    }

}
