package io.twotle.sunrinapple.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.twotle.sunrinapple.R
import io.twotle.sunrinapple.databinding.ItemMemoBinding
import io.twotle.sunrinapple.databinding.ItemOnlyTitleBinding
import io.twotle.sunrinapple.model.MemoItem
import io.twotle.sunrinapple.model.OnlyTitleItem

class OnlyTitleViewHolder(private val binding: ItemOnlyTitleBinding): BaseViewHolder<OnlyTitleItem>(binding.root) {
    override fun bind(item: OnlyTitleItem) {
        binding.tvTitle.text = item.title
    }
    companion object {
        val DIFF = object : DiffUtil.ItemCallback<OnlyTitleItem>(){
            override fun areItemsTheSame(oldItem: OnlyTitleItem, newItem: OnlyTitleItem): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: OnlyTitleItem, newItem: OnlyTitleItem): Boolean {
                return oldItem == newItem
            }

        }
        val CREATOR :(ViewGroup) -> OnlyTitleViewHolder =  { parent ->
            //val _binding = DataBindingUtil.bind<ItemOnlyTitleBinding>();
            val binding = ItemOnlyTitleBinding.inflate(LayoutInflater.from(parent.context))
            OnlyTitleViewHolder(binding)
        }
    }
}