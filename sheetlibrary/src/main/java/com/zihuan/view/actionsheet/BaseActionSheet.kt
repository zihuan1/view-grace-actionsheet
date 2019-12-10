package com.zihuan.view.actionsheet

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @author Zihuan
 */
open class BaseActionSheet(var mContext: Context) {
    internal var mSheetDialog: BottomSheetDialog = BottomSheetDialog(mContext)
    internal lateinit var behavior: BottomSheetBehavior<*>

    fun setView(view: View) {
        mSheetDialog.setContentView(view)
        //RecyclerView部分透明度 整体蒙层设置不是这
        mSheetDialog.delegate.findViewById<View>(R.id.design_bottom_sheet)
            ?.setBackgroundColor(Color.parseColor("#00000000"))
        behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.peekHeight = screenHeight
        behavior.setBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    mSheetDialog.dismiss()
                    behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    val screenHeight: Int
        get() {
            val manager = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            var dm = DisplayMetrics()
            manager.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }

    /***
     * 显示
     * @return
     */
    fun show() {
        if (mContext is Activity && !(mContext as Activity).isFinishing) {
            mSheetDialog.show()
        }
    }

    /***
     * 隐藏
     * @return
     */
    fun dismiss() {
        mSheetDialog.dismiss()
    }

}