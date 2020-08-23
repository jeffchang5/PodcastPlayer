package io.jeffchang.businesslist.ui.business.view

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
import io.jeffchang.businesslist.R
import io.jeffchang.businesslist.databinding.FragmentBusinessListBinding
import io.jeffchang.businesslist.ui.business.inject
import io.jeffchang.businesslist.ui.business.view.adapter.BusinessListAdapter
import io.jeffchang.businesslist.ui.business.viewmodel.BusinessViewModel
import io.jeffchang.core.data.ViewState
import javax.inject.Inject

class BusinessListFragment : Fragment() {

    private lateinit var binding: FragmentBusinessListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    // Kotlin delegate to lazily create viewmodels.
    private val businessViewModel by viewModels<BusinessViewModel> {
        viewModelFactory
    }

    private val businessListAdapter by lazy {
        BusinessListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        binding = FragmentBusinessListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            businessListRecyclerView.adapter = businessListAdapter
            businessListRecyclerView.layoutManager = LinearLayoutManager(context)
            swipeRefreshLayout.setOnRefreshListener {
                businessViewModel.getBusinesses()
            }
        }
        subscribeUI()
    }

    private fun subscribeUI() {
        binding.apply {
            // Hides main UI with list. Shows Progress Bar.
            fun hide() {
                progressBar.isVisible = true
                businessListRecyclerView.isVisible = false
            }

            // Shows main UI with list
            fun show() {
                progressBar.isVisible = false
                businessListRecyclerView.isVisible = true
            }

            businessViewModel.viewState().observe(viewLifecycleOwner, Observer {
                binding.swipeRefreshLayout.isRefreshing = false
                when (it) {
                    is ViewState.Success -> {
                        businessListAdapter.submitList(it.data)
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
                        businessListRecyclerView.isVisible = false
                        hide()
                    }
                }
            })
        }
    }
}
