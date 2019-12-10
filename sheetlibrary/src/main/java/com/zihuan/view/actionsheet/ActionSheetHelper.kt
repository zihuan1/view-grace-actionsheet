package com.zihuan.view.actionsheet

import android.content.Context
import android.view.View


inline fun <T : ActionBaseView> zSheetView(view: BaseActionSheet<T>, init: T.() -> Unit) =
    view.apply {
        init(view.getView())
    }

/***
 * 默认实现
 */
inline fun Context.defSheetView(noinline init: DefaultView.() -> Unit) =
    BottomSheetView<DefaultView>(this).apply {
        setView(DefaultView(this@defSheetView, this))
        zSheetView(this, init)
    }
