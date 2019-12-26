package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View


inline fun <T : BaseActionView> BaseActionSheet<T>.zSheetView(view: T, noinline init: T.() -> Unit) =
        apply { setView(view, init) }

inline fun <T : BaseActionView> Context.zBottomSheetView(view: T, noinline init: T.() -> Unit) =
        BottomSheetView<T>(this).zSheetView(view, init)

inline fun <T : BaseActionView> View.zPopupView(view: T, noinline init: T.() -> Unit) =
        ActionPopupSheet<T>(context, this).zSheetView(view, init)

/***
 * 默认实现
 */
inline fun Context.defSheetView(noinline init: DefaultActionView.() -> Unit) =
        zBottomSheetView(DefaultActionView(this), init)

inline fun View.defPopupView(noinline init: DefaultActionView.() -> Unit) =
        zPopupView(DefaultActionView(context), init)
