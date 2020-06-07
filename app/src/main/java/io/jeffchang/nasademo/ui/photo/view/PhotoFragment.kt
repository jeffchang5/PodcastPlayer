package io.jeffchang.nasademo.ui.photo.view

import android.content.Context
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
import io.jeffchang.core.data.ViewState
import io.jeffchang.nasademo.PhotoActivity
import io.jeffchang.nasademo.R
import io.jeffchang.nasademo.databinding.FragmentPhotoBinding
import io.jeffchang.nasademo.ui.photo.inject
import io.jeffchang.nasademo.ui.photo.view.adapter.PhotoListAdapter
import io.jeffchang.nasademo.ui.photo.viewmodel.PhotoViewModel
import io.jeffchang.nasademo.ui.photo.viewmodel.SortingStrategy
import kotlinx.android.synthetic.main.fragment_photo.view.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PhotoFragment : Fragment() {

    private var callback: Callback? = null

    private lateinit var binding: FragmentPhotoBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val photoViewModel by viewModels<PhotoViewModel> {
        viewModelFactory
    }

    private val photoListAdapter by lazy {
        PhotoListAdapter()
    }

    private val listener =
        object : PhotoActivity.OnActivityUiInteraction {
            override fun onUseMalformedChanged(useMalformed: Boolean) {
                photoViewModel.getPhotos(useMalformed = useMalformed)
            }

            override fun onSortChanged(sortingStrategy: SortingStrategy) {
                photoViewModel.getPhotos(sortingStrategy)
            }
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? Callback
        callback?.setOnSortChangedListener(listener)
    }

    override fun onDetach() {
        super.onDetach()
        callback?.setOnSortChangedListener(null)
        callback = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            photoRecyclerView.adapter = photoListAdapter
            photoRecyclerView.photoRecyclerView.layoutManager = LinearLayoutManager(context)
            swipeRefreshLayout.setOnRefreshListener {
                photoViewModel.getPhotos()
            }
        }
        subscribeUI()
    }

    private fun subscribeUI() {
        binding.apply {
            fun hide() {
                progressBar.isVisible = true
                photoRecyclerView.isVisible = false
            }
            fun show() {
                progressBar.isVisible = false
                photoRecyclerView.isVisible = true
            }
            photoViewModel.viewState().observe(viewLifecycleOwner, Observer {
                binding.swipeRefreshLayout.isRefreshing = false
                when (it) {
                    is ViewState.Success -> {
                        photoListAdapter.submitList(it.data)
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
                        photoRecyclerView.isVisible = false
                        hide()
                    }
                }
            })
        }
    }

    interface Callback {

        fun setOnSortChangedListener(
            onActivityUiInteraction: PhotoActivity.OnActivityUiInteraction?
        )
    }
}
