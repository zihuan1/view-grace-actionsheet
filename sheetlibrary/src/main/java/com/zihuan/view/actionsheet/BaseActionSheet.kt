package com.zihuan.view.actionsheet

import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

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
    fun touchOutside(outside: Boolean): BaseActionSheet<T>

    fun getSheetDialog(): BottomSheetDialog

    /**
     *   默认展示状态
     *   STATE_COLLAPSED – 可见但仅显示其窥视高度。这种状态通常是底片的“静止位置”。
     *   STATE_EXPANDED – 底部工作表是可见的，它的最大高度是既不拖动也不沉降。
     *   STATE_DRAGGING – 用户正在主动向上或向下拖动底部工作表。
     *   STATE_SETTLING – 在拖动/滑动手势后稳定到特定高度。
     *   STATE_HIDDEN – 不再可见。
     */
    fun setState(@BottomSheetBehavior.State state: Int): BaseActionSheet<T>

    /**
     * 是否可以隐藏
     * @param state true 可以隐藏 false 不可隐藏
     */
    fun setHideable(state: Boolean): BaseActionSheet<T>

    /**
     * 设置窥视高度
     */
    fun setPeekHeight(height: Int): BaseActionSheet<T>

    /**
     * 设置背景透明度
     * @param amount 从0到1的小数
     */
    fun setDimAmount(amount: Float): BaseActionSheet<T>

}