package com.code.knab.best_quiz.utils.recycler

import android.support.v7.util.DiffUtil

/**
 * Created by Michał on 21.04.2018.
 */
abstract class BasicViewUtils<in T>(private val oldList: List<T>, private val newList: List<T>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areItemsTeSame(oldList[oldItemPosition], newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    abstract fun areItemsTeSame(t1: T, t2: T): Boolean
}