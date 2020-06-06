package io.jeffchang.nasademo.ui.photo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.data.ViewState
import io.jeffchang.core.onFailure
import io.jeffchang.core.onSuccess
import io.jeffchang.nasademo.ui.photo.data.Photo
import io.jeffchang.nasademo.ui.photo.usecase.GetMalformedPhotosUseCase
import io.jeffchang.nasademo.ui.photo.usecase.GetNASAPhotosUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class PhotoViewModel @Inject constructor(
    private val contextProvider: ContextProvider,
    private val getPhotosUseCase: GetNASAPhotosUseCase,
    getMalformedPhotosUseCase: GetMalformedPhotosUseCase
) : ViewModel() {

    private val viewState = MutableLiveData<ViewState<List<Photo>>>()

    init {
        getPhotos()
    }

    fun viewState(): LiveData<ViewState<List<Photo>>> = viewState

    fun getPhotos() {
        launch {
            getPhotosUseCase(Unit)
                .onSuccess {
                    Timber.d("Received photos")
                    viewState.postValue(ViewState.Success(it))
                }
                .onFailure {
                    // TODO: Handle errors
                }
        }
    }

    private fun launch(
        coroutineContext: CoroutineContext = contextProvider.main,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch(coroutineContext) { block() }
    }
}
