package io.twotle.sunrinapple.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<E>(view: View) : RecyclerView.ViewHolder(view){
    abstract fun bind(item: E)
}