package com.example.sunflower_clone.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sunflower_clone.GardenFragment
import com.example.sunflower_clone.PlantListFragment
import java.lang.IndexOutOfBoundsException

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1

class SunflowerPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */
    private val tabFragmentCreators: Map<Int, () -> Fragment> = mapOf(
            MY_GARDEN_PAGE_INDEX to { GardenFragment() },
            PLANT_LIST_PAGE_INDEX to { PlantListFragment() }
    )

    override fun getItemCount() = tabFragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw  IndexOutOfBoundsException()
    }
}