package com.zihuan.view.actionsheet

import android.app.Activity
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
open class BaseBottomSheet(var mActivity: Activity) {
    internal var mSheetDialog: BottomSheetDialog = BottomSheetDialog(mActivity)
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
            val manager = mActivity.getSystemService(Activity.WINDOW_SERVICE) as WindowManager
            var dm = DisplayMetrics()
            manager.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }

    fun showView() {
        if (!mActivity.isFinishing) {
            mSheetDialog.show()
        }
    }

    fun dismissView() {
        mSheetDialog.dismiss()
    }

}