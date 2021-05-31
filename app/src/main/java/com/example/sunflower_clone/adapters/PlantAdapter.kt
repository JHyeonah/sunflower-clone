package com.example.sunflower_clone.adapters

import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower_clone.data.Plant

class PlantAdapter : ListAdapter<Plant, RecyclerView.ViewHolder>() {
    class PlantViewHolder() : RecyclerView.ViewHolder(binding.root) {

    }
}