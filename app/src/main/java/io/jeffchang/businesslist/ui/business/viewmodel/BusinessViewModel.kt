package io.jeffchang.businesslist.ui.business.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.data.ViewState
import io.jeffchang.core.onFailure
import io.jeffchang.core.onSuccess
import io.jeffchang.businesslist.ui.business.data.model.business.Business
import io.jeffchang.businesslist.ui.business.usecase.DefaultGetBusinessUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class BusinessViewModel @Inject constructor(
    private val contextProvider: ContextProvider,
    private val getBusinessUseCase: DefaultGetBusinessUseCase
) : ViewModel() {

    private val viewState = MutableLiveData<ViewState<List<Business>>>()

    init {
        getBusinesses()
    }

    fun viewState(): LiveData<ViewState<List<Business>>> = viewState

    fun getBusinesses() {
        launch {
            getBusinessUseCase("coffee")
                .onSuccess {
                    if (it.isEmpty()) {
                        viewState.postValue(ViewState.Empty())
                        return@onSuccess
                    }
                    Timber.d("Received Businesses")
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
