package io.jeffchang.nasademo.ui.photo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.jeffchang.core.data.ViewState
import io.jeffchang.nasademo.R
import io.jeffchang.nasademo.ui.photo.di.inject
import io.jeffchang.nasademo.ui.photo.viewmodel.PhotoViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PhotoFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val photoViewModel by viewModels<PhotoViewModel> {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUI()
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun subscribeUI() {
        photoViewModel.viewState().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Success -> {

                }
                is ViewState.Empty -> {

                }
                is ViewState.Error -> {

                }
                is ViewState.Loading -> {

                }
            }
        })
    }
}
