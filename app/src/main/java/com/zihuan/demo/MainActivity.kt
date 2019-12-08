package com.zihuan.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zihuan.view.actionsheet.BottomSheetView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = ArrayList<String>()
        list.add("一")
        list.add("二")
        tv_1.setOnClickListener {
            BottomSheetView.build(this).setData(*list.toTypedArray()).showDialog()
        }
    }
}
