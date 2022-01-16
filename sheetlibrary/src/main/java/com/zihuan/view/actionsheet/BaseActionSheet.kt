package com.zihuan.view.actionsheet

import android.app.Dialog

/**
 * @author Zihuan
 */
interface BaseActionSheet<T : BaseActionView> {

    /**
     * 设置View
     */
    fun setView(view: T, init: T.() -> Unit)

    /**
     * 获取View
     */
    fun getView(): T

    /***
     * 显示
     * @return
     */
    fun show(xoff: Int = 0, yoff: Int = 0)

    /***
     * 隐藏
     */
    fun dismiss()

    /**
     * 点击边缘是否可隐藏
     */
    fun touchOutside(outside: Boolean)

    fun getSheetDialog(): Any

}