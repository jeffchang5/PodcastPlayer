package io.jeffchang.podcast.ui.podcast.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.jeffchang.podcast.databinding.FragmentPodcastListBinding
import io.jeffchang.podcast.R
import io.jeffchang.podcast.ui.podcast.inject
import io.jeffchang.podcast.ui.podcast.view.adapter.PodcastListAdapter
import io.jeffchang.podcast.ui.podcast.viewmodel.PodcastViewModel
import io.jeffchang.core.data.ViewState
import javax.inject.Inject

class PodcastListFragment : Fragment() {

    private lateinit var binding: FragmentPodcastListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    // Kotlin delegate to lazily create viewmodels.
    private val podcastListViewModel by viewModels<PodcastViewModel> {
        viewModelFactory
    }

    private val podcastListAdapter by lazy {
        PodcastListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        binding = FragmentPodcastListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            podcastListRecyclerView.adapter = podcastListAdapter
            podcastListRecyclerView.layoutManager = LinearLayoutManager(context)
            swipeRefreshLayout.setOnRefreshListener {
                podcastListViewModel.getBusinesses()
            }
        }
        subscribeUI()
        podcastListViewModel.getBusinesses()
    }

    private fun subscribeUI() {
        binding.apply {
            // Hides main UI with list. Shows Progress Bar.
            fun hide() {
                progressBar.isVisible = true
                podcastListRecyclerView.isVisible = false
            }

            // Shows main UI with list
            fun show() {
                progressBar.isVisible = false
                podcastListRecyclerView.isVisible = true
            }

            podcastListViewModel.viewState().observe(viewLifecycleOwner, Observer {
                binding.swipeRefreshLayout.isRefreshing = false
                when (it) {
                    is ViewState.Success -> {
                        podcastListAdapter.submitList(it.data)
                        show()
                    }
                    is ViewState.Empty -> {
                        Toast.makeText(context, R.string.empty_list, Toast.LENGTH_LONG).show()
                        show()
                    }
                    is ViewState.Error -> {
                        Toast.makeText(context, R.string.network_error, Toast.LENGTH_LONG).show()
                        show()
                    }
                    is ViewState.Loading -> {
                        progressBar.isVisible = true
                        podcastListRecyclerView.isVisible = false
                        hide()
                    }
                }
            })
        }
    }
}
