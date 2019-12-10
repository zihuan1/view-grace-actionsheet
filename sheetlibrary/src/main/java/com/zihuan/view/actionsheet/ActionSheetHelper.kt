package com.zihuan.view.actionsheet

import android.content.Context


inline fun <T : ActionBaseView> zSheetView(view: T, init: T.() -> Unit) = view.apply { init() }

/***
 * 默认实现
 */
inline fun Context.defSheetView(noinline init: DefaultView.() -> Unit) =
    BottomSheetView<DefaultView>(this).apply {
        setView(DefaultView(this@defSheetView, this))
        zSheetView(getView(), init)
    }
