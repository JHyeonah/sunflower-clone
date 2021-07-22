package com.example.sunflower_clone.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.sunflower_clone.data.GardenPlantingRepository
import com.example.sunflower_clone.data.PlantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(
        savedStateHandle: SavedStateHandle,
        plantRepository: PlantRepository,
        private val gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {

    val plantId: String = savedStateHandle.get<String>(PLANT_ID_STAVED_STATE_KEY)!!

    companion object {
        private const val PLANT_ID_STAVED_STATE_KEY = "plantId"
    }
}