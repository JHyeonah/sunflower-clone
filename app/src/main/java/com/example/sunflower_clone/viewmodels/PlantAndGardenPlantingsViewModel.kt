package com.example.sunflower_clone.viewmodels

import com.example.sunflower_clone.data.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*

class PlantAndGardenPlantingsViewModel(plantings: PlantAndGardenPlantings) {
    private val plant = checkNotNull(plantings.plant)
    private val gardenPlanting = plantings.gardenPlantings[0]

    val waterDateString: String = dateFormat.format(gardenPlanting.lastWateringDate.time)
    val wateringInterval get() = plant.wateringInterval
    val imageUrl get() = plant.imageUrl
    val plantName = plant.name
    val plantDateString: String = dateFormat.format(gardenPlanting.plantDate.time)
    val plantId get() = plant.plantId

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.KOREA)
    }
}