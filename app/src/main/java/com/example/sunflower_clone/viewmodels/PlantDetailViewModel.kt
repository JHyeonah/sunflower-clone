package com.example.sunflower_clone.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.sunflower_clone.BuildConfig
import com.example.sunflower_clone.data.GardenPlantingRepository
import com.example.sunflower_clone.data.PlantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(
        savedStateHandle: SavedStateHandle,
        plantRepository: PlantRepository,
        private val gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {

    val plantId: String = savedStateHandle.get<String>(PLANT_ID_STAVED_STATE_KEY)!!
    val isPlanted = gardenPlantingRepository.isPlanted(plantId).asLiveData()
    val plant = plantRepository.getPlant(plantId).asLiveData()

    fun addPlantToGarden() {
        viewModelScope.launch {
            gardenPlantingRepository.createGardenPlanting(plantId)
        }
    }

    fun hasValidUnsplashKey() = (BuildConfig.UNSPLASH_ACCESS_KEY != "null")

    companion object {
        private const val PLANT_ID_STAVED_STATE_KEY = "plantId"
    }
}