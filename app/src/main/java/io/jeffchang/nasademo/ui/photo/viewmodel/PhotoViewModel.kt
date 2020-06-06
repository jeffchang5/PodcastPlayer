package io.jeffchang.nasademo.ui.photo.viewmodel

import androidx.lifecycle.ViewModel
import io.jeffchang.core.ContextProvider
import javax.inject.Inject

class PhotoViewModel @Inject constructor(
    contextProvider: ContextProvider
) : ViewModel() {


    init {
        println("hello world")
    }

}
