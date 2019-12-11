package com.zihuan.view.actionsheet

/**
 * @author Zihuan
 */
interface BaseActionSheet<T : BaseActionView> {

    /**
     * 设置View
     */
    fun setView(view: T,init: T.() -> Unit)

    /**
     * 获取View
     */
    fun getView(): T

    /***
     * 显示
     * @return
     */
    fun show(xoff: Int=0, yoff: Int=0)

    /***
     * 隐藏
     */
    fun dismiss()

}