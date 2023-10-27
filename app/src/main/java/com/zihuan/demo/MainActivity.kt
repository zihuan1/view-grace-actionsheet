package com.zihuan.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zihuan.view.actionsheet.*
import com.zihuan.view.actionsheet.listener.BottomSheetItemListener
import com.zihuan.view.actionsheet.listener.BottomSheetListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
        BottomSheetItemListener, BottomSheetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = ArrayList<String>()
        (1..6).forEach {
            list.add("按钮 $it")
        }
        //        //   1 推荐用法
        val sheet = defBottomSheetView {
            dataList = list
        }
        sheet.setHideable(false)
                .setState(ActionSheetHelper.STATE_EXPANDED)
//            .touchOutside(false)
                .setDimAmount(.1f)
//            .setPeekHeight(2244)
//                .setShowListener {
//                    Toast.makeText(this, "显示了", Toast.LENGTH_SHORT).show()
//                }
//                .setDismissListener {
//                    Toast.makeText(this, "隐藏", Toast.LENGTH_SHORT).show()
//                }
                .setStatusListener(this)

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
            sheet.getView().setItemListener { position ->
                Toast.makeText(this@MainActivity, "asd位置$position", Toast.LENGTH_SHORT).show()
                sheet.dismiss()
            }
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
        }
        tv_bottom.setOnClickListener {
        }

    }

    override fun onSheetItemClick(position: Int) {
        Toast.makeText(this, "位置$position", Toast.LENGTH_SHORT).show()
    }

    override fun onShow() {
        Toast.makeText(this, "显示了", Toast.LENGTH_SHORT).show()
    }

    override fun onDismiss() {
        Toast.makeText(this, "取消了", Toast.LENGTH_SHORT).show()
    }


}
