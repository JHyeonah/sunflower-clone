package com.example.sunflower_clone

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ShareCompat
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sunflower_clone.data.Plant
import com.example.sunflower_clone.databinding.FragmentPlantDetailBinding
import com.example.sunflower_clone.viewmodels.PlantDetailViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
                    hideAppBarFab(fab)
                    plantDetailViewModel.addPlantToGarden()
                    Snackbar.make(root, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show()
                }
            }

            galleryNav.setOnClickListener {  }

            var isToolbarShown = false

            plantDetailScrollview.setOnScrollChangeListener(
                    NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                        // User scrolled past image to height of toolbar and the title text is
                        // underneath the toolbar, so the toolbar should be shown.'
                        val shouldShowToolbar = scrollY > toolbar.height

                        if (isToolbarShown != shouldShowToolbar) {
                            isToolbarShown = shouldShowToolbar

                            // Use shadow animator to add elevation if toolbar is shown
                            appbar.isActivated = shouldShowToolbar
                            // Show the plant name if toolbar is shown
                            toolbarLayout.isTitleEnabled = shouldShowToolbar
                        }
                    }
            )

            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_share -> {
                        createShareIntent()
                        true
                    }
                    else -> false
                }
            }
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun navigateToGallery() {
        plantDetailViewModel.plant.value?.let { plant ->

        }
    }

    private fun createShareIntent() {
        val shareText = plantDetailViewModel.plant.value.let { plant ->
            if (plant == null) {
                ""
            } else {
                getString(R.string.share_text_plant, plant.name)
            }
        }
        val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setText(shareText)
                .setType("text/plain")
                .createChooserIntent()
                .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        startActivity(shareIntent)
    }

    // FloatingActionButtons anchored to AppBarLayouts have their visibility controlled by the scroll position.
    // We want to turn this behavior off to hide the FAB when it is clicked.
    // This is adapted from Chris Banes' Stack Overflow answer: https://stackoverflow.com/a/41442923
    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()
    }


    fun interface Callback {
        fun add(plant: Plant?)
    }
}