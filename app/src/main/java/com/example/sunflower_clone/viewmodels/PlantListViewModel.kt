package com.example.sunflower_clone.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.sunflower_clone.data.PlantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PlantListViewModel @Inject internal constructor(
        plantRepository: PlantRepository,
        private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val growZone: MutableStateFlow<Int> = MutableStateFlow(savedStateHandle.get(GROW_ZONE_SAVED_STATE_KEY) ?: NO_GROW_ZONE)


    companion object {
        private const val NO_GROW_ZONE = -1
        private const val GROW_ZONE_SAVED_STATE_KEY = "GROW_ZONE_SAVED_STATE_KEY"
    }
}