package com.noox.checklist.superzings.ui

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noox.checklist.core.model.SuperZing
import com.noox.checklist.databinding.ItemListSuperZingBinding

class SuperZingViewHolder(
    private val binding: ItemListSuperZingBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(superZing: SuperZing) {
        binding.name.text = superZing.name
        binding.number.text = superZing.number.toString()
        binding.variocolor.text = superZing.variocolor.toString()

        Glide.with(itemView.context).load(superZing.url).into(binding.image)
    }

}
