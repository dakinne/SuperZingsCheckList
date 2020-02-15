package com.noox.checklist.superzings.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noox.checklist.core.model.SuperZing
import com.noox.checklist.databinding.ItemListSuperZingBinding

class SuperZingsAdapter(
    private val items: List<SuperZing>
) : RecyclerView.Adapter<SuperZingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SuperZingViewHolder(
        binding = ItemListSuperZingBinding.inflate(LayoutInflater.from(parent.context), parent,false)
    )

    override fun onBindViewHolder(holder: SuperZingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
