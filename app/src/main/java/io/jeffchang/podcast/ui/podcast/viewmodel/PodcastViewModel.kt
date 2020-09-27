package io.jeffchang.podcast.ui.podcast.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jeffchang.podcast.ui.podcast.data.model.podcastlist.PodcastItem
import io.jeffchang.podcast.ui.podcast.usecase.GetPodcastUseCase
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.data.ViewState
import io.jeffchang.core.onFailure
import io.jeffchang.core.onSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class PodcastViewModel @Inject constructor(
    private val contextProvider: ContextProvider,
    private val getBusinessUseCase: GetPodcastUseCase
) : ViewModel() {

    private val viewState = MutableLiveData<ViewState<List<PodcastItem>>>()

    init {
        getPodcasts()
    }

    fun viewState(): LiveData<ViewState<List<PodcastItem>>> = viewState

    fun getPodcasts(q: String = "Joe Rogan") {
        launch {
            getBusinessUseCase(q)
                .onSuccess {
                    if (it.isEmpty()) {
                        viewState.postValue(ViewState.Empty())
                        return@onSuccess
                    }
                    Timber.d("Received podcasts ")
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
