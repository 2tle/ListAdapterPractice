package io.twotle.sunrinapple.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.twotle.sunrinapple.databinding.ItemMemoBinding
import io.twotle.sunrinapple.model.MemoItem

class MemoViewHolder(private val binding: ItemMemoBinding): BaseViewHolder<MemoItem>(binding.root) {
    override fun bind(item: MemoItem) {
        binding.tvTitle.text = item.title
        binding.tvDescription.text = item.description
    }

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<MemoItem>(){
            override fun areItemsTheSame(oldItem: MemoItem, newItem: MemoItem): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: MemoItem, newItem: MemoItem): Boolean {
                return oldItem == newItem
            }

        }
        val CREATOR :(ViewGroup) -> MemoViewHolder =  { parent ->
            val binding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context))
            MemoViewHolder(binding)
        }
    }
}