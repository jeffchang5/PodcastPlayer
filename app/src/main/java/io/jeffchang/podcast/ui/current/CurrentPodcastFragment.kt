package io.jeffchang.podcast.ui.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import io.jeffchang.podcast.databinding.FragmentCurrentPodcastBinding
import io.jeffchang.podcast.ui.podcast.viewmodel.PodcastViewModel
import javax.inject.Inject

class CurrentPodcastFragment : Fragment() {

    private val args: CurrentPodcastFragmentArgs by navArgs()

    private lateinit var binding: FragmentCurrentPodcastBinding

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//
//    // Kotlin delegate to lazily create viewmodels.
//    private val podcastListViewModel by viewModels<PodcastViewModel> {
//        viewModelFactory
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        inject()
        binding = FragmentCurrentPodcastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }
        subscribeUI()
    }

    private fun subscribeUI() {
        binding.apply {

        }
    }
}
