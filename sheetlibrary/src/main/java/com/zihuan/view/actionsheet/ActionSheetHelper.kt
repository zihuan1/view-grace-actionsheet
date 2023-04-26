package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior

object ActionSheetHelper {
    // 可见但仅显示其窥视高度。这种状态通常是底片的“静止位置”
    const val STATE_COLLAPSED = BottomSheetBehavior.STATE_COLLAPSED

    //底部工作表是可见的，它的最大高度是既不拖动也不沉降。
    const val STATE_EXPANDED = BottomSheetBehavior.STATE_EXPANDED

    //用户正在主动向上或向下拖动底部工作表。
    const val STATE_DRAGGING = BottomSheetBehavior.STATE_DRAGGING

    //在拖动/滑动手势后稳定到特定高度。
    const val STATE_SETTLING = BottomSheetBehavior.STATE_SETTLING

    //不再可见。
    const val STATE_HIDDEN = BottomSheetBehavior.STATE_HIDDEN
}

inline fun <reified T : BaseActionView> BaseActionSheet<T>.sheetView(
    context: Context,
    noinline init: T.() -> Unit
) =
    apply {
        val view =
            T::class.java.getDeclaredConstructor(Context::class.java, BaseActionSheet::class.java)
                .newInstance(context, this)
        setView(view, init)
    }

inline fun <reified T : BaseActionView> Context.bottomSheetView(noinline init: T.() -> Unit) =
    BottomSheetView<T>(this).sheetView(this, init)

/***
 * 默认实现
 */
inline fun Context.defBottomSheetView(noinline init: DefaultActionView.() -> Unit) =
    bottomSheetView(init)
