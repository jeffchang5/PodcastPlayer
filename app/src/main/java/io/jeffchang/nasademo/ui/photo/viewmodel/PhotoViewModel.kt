package io.jeffchang.nasademo.ui.photo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.data.ViewState
import io.jeffchang.core.onFailure
import io.jeffchang.core.onSuccess
import io.jeffchang.nasademo.ui.photo.data.model.Photo
import io.jeffchang.nasademo.ui.photo.usecase.GetMalformedPhotosUseCase
import io.jeffchang.nasademo.ui.photo.usecase.GetNASAPhotosUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


enum class SortingStrategy {
    ROVER, EARTH_DATE, CAMERA_TYPE
}

class PhotoViewModel @Inject constructor(
    private val contextProvider: ContextProvider,
    private val getPhotosUseCase: GetNASAPhotosUseCase,
    getMalformedPhotosUseCase: GetMalformedPhotosUseCase
) : ViewModel() {

    private var sortingStrategy = SortingStrategy.EARTH_DATE

    private val viewState = MutableLiveData<ViewState<List<Photo>>>()

    init {
        getPhotos()
    }

    fun viewState(): LiveData<ViewState<List<Photo>>> = viewState

    fun getPhotos(sortingStrategy: SortingStrategy = this.sortingStrategy) {
        this.sortingStrategy = sortingStrategy
        launch {
            getPhotosUseCase(sortingStrategy)
                .onSuccess {
                    if (it.isEmpty()) {
                        viewState.postValue(ViewState.Empty())
                        return@onSuccess
                    }
                    Timber.d("Received photos")
                    viewState.postValue(ViewState.Success(it))
                }
                .onFailure {
                    viewState.postValue(ViewState.Error(it))
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
