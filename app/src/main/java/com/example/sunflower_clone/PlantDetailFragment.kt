package com.example.sunflower_clone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sunflower_clone.data.Plant
import com.example.sunflower_clone.databinding.FragmentPlantDetailBinding
import com.example.sunflower_clone.viewmodels.PlantDetailViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantDetailFragment : Fragment() {
    private val plantDetailViewModel: PlantDetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(inflater, R.layout.fragment_plant_detail, container, false).apply {
            viewModel = plantDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = Callback { plant ->
                plant.let {
                    plantDetailViewModel.addPlantToGarden()
                    Snackbar.make(root, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show()
                }
            }

            galleryNav.setOnClickListener {  }

            var isToolbarShown = false


        }


        return binding.root
    }

    fun interface Callback {
        fun add(plant: Plant?)
    }
}