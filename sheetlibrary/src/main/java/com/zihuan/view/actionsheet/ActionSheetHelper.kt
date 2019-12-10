package com.zihuan.view.actionsheet

import android.content.Context


inline fun <T : BaseActionSheet> zSheetView(view: T, init: T.() -> Unit) = view.apply { init(view) }

/***
 * 默认实现
 */
inline fun Context.defSheetView(noinline init: BottomSheetView.() -> Unit) =
    zSheetView(BottomSheetView.build(this), init)
