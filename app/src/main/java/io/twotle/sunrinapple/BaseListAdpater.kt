package io.twotle.sunrinapple

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import io.twotle.sunrinapple.databinding.ItemMemoBinding
import io.twotle.sunrinapple.databinding.ItemOnlyTitleBinding
import io.twotle.sunrinapple.model.Item
import io.twotle.sunrinapple.model.MemoItem
import io.twotle.sunrinapple.model.OnlyTitleItem
import io.twotle.sunrinapple.viewholder.BaseViewHolder
import io.twotle.sunrinapple.viewholder.MemoViewHolder

class BaseListAdpater<E: Any>(private val factory: BaseViewHolderFactory<E>) : ListAdapter<E, BaseViewHolder< E>>(
    object: DiffUtil.ItemCallback<E>() {
        override fun areItemsTheSame(oldItem: E, newItem: E): Boolean {
            if(oldItem::class != newItem::class) return false


            return factory.getDiffUtilCallback(newItem::class)?.areItemsTheSame(oldItem,newItem) ?:false
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: E, newItem: E): Boolean {
            if(oldItem::class != newItem::class) return false
            return factory.getDiffUtilCallback(newItem::class)?.areContentsTheSame(oldItem,newItem) ?:false
        }

    }

) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder< E> {
        return factory.createViewHolder(viewType, parent) as BaseViewHolder<E>

    }

    override fun onBindViewHolder(holder: BaseViewHolder< E>, position: Int) {
        holder.bind(getItem(position))

    }

    override fun getItemViewType(position: Int): Int {
        return factory.getViewType(getItem(position)::class)
    }




}