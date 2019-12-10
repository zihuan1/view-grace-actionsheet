package com.zihuan.view.actionsheet

/**
 * @author Zihuan
 */
interface BaseActionSheet<T : ActionBaseView> {

    /**
     * 设置View
     */
    fun setView(view: T)

    /**
     * 获取View
     */
    fun getView(): T
    /***
     * 显示
     * @return
     */
    fun show()

    /***
     * 隐藏
     */
    fun dismiss()

}