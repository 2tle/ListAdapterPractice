package io.twotle.sunrinapple

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import io.twotle.sunrinapple.viewholder.BaseViewHolder
import kotlin.reflect.KClass

class BaseViewHolderFactory<S: Any> {

    private val viewHolderMap = mutableMapOf<Int,(ViewGroup) ->  BaseViewHolder<*>>()
    private val diffUtilMap = mutableMapOf<KClass<out S>, DiffUtil.ItemCallback<out S>>()
    private val viewTypeMap = mutableMapOf<KClass<out S>, Int>()

    fun <T: S>add(
        classInfo: KClass<out S>,
        viewHolder: (ViewGroup) -> BaseViewHolder<T>,
        diffUtil: DiffUtil.ItemCallback<T>
    ): BaseViewHolderFactory<S> {
        val viewType = classInfo.hashCode()
        viewHolderMap[viewType] = viewHolder
        diffUtilMap[classInfo] = diffUtil
        viewTypeMap[classInfo] = viewType

        return this

    }

    fun getDiffUtilCallback(classInfo: KClass<out S>) : DiffUtil.ItemCallback< S>? {
        return diffUtilMap[classInfo] as? DiffUtil.ItemCallback<S>
    }

    fun getViewType(classInfo: KClass<out S>): Int {
        return viewTypeMap[classInfo] ?: 0
    }

    fun createViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder<*> {
        return viewHolderMap[viewType]!!.invoke(parent)
    }

}

fun <T: Any> BaseViewHolderFactory<T>.buildAdapter(): BaseListAdpater<T> {
    return BaseListAdpater(this)
}