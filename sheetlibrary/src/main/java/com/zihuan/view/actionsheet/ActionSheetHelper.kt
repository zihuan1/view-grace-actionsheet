package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View


inline fun <reified T : BaseActionView> BaseActionSheet<T>.sheetView(
    context: Context,
    noinline init: T.() -> Unit
) =
    apply {
        val view = T::class.java.getDeclaredConstructor(Context::class.java).newInstance(context)
        setView(view, init)
    }

inline fun <reified T : BaseActionView> Context.bottomSheetView(noinline init: T.() -> Unit) =
    BottomSheetView<T>(this).sheetView(this, init)

inline fun <reified T : BaseActionView> View.sheetView(noinline init: T.() -> Unit) =
    ActionPopupSheet<T>(context, this).sheetView(context, init)

/***
 * 默认实现
 */
inline fun Context.defBottomSheetView(noinline init: DefaultActionView.() -> Unit) =
    bottomSheetView(init)

inline fun View.defSheetView(noinline init: DefaultActionView.() -> Unit) = sheetView(init)
