package com.example.sunflower_clone

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.sunflower_clone.adapters.PlantAdapter
import com.example.sunflower_clone.databinding.FragmentPlantListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentPlantListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = PlantAdapter()
        binding.plantList.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_plant_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.filter_zone -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun subscribeUi(adapter: PlantAdapter) {

    }
}