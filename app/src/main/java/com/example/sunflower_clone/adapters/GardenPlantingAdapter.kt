package com.example.sunflower_clone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sunflower_clone.R
import com.example.sunflower_clone.data.PlantAndGardenPlantings
import com.example.sunflower_clone.databinding.ListItemGardenPlantingBinding
import com.example.sunflower_clone.databinding.ListItemPlantBinding
import com.example.sunflower_clone.viewmodels.PlantAndGardenPlantingsViewModel

class GardenPlantingAdapter: ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder>(
    GardenPlantingDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.list_item_garden_planting, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ListItemGardenPlantingBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.viewModel?.plantId?.let { plantId ->
                    navigateToPlant(plantId, view)
                }
            }
        }

        private fun navigateToPlant(plantId: String, view: View) {

        }

        fun bind(plantings: PlantAndGardenPlantings) {
            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(plantings)
                executePendingBindings()
            }
        }
    }
}

private class GardenPlantingDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {
    override fun areItemsTheSame(oldItem: PlantAndGardenPlantings, newItem: PlantAndGardenPlantings): Boolean {
        return oldItem.plant.plantId == newItem.plant.plantId
    }

    override fun areContentsTheSame(oldItem: PlantAndGardenPlantings, newItem: PlantAndGardenPlantings): Boolean {
        return oldItem.plant == newItem.plant
    }
}