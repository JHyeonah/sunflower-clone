package com.example.sunflower_clone.adapters

import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower_clone.data.Plant

class PlantAdapter : ListAdapter<Plant, RecyclerView.ViewHolder>() {
    class PlantViewHolder() : RecyclerView.ViewHolder(binding.root) {

    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }
}