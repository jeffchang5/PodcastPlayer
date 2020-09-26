package io.jeffchang.podcast.ui.podcast.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.jeffchang.core.*
import io.jeffchang.core.data.ViewState
import io.jeffchang.podcast.ui.podcast.repository.PodcastRepository
import io.jeffchang.podcast.ui.podcast.usecase.DefaultGetPodcastUseCase
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class PodcastViewModelTest {

    private val coroutineContext = TestContextProvider()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Test
    fun `non-empty business list is success viewstate`() {
        runBlocking {
            val podcastRepository: PodcastRepository = mock()
            whenever(podcastRepository.getPodcasts(any())).doReturn(Success(listOf(Business())))

            val useCase = DefaultGetPodcastUseCase(podcastRepository)

            val businessViewModel = PodcastViewModel(
                this@PodcastViewModelTest.coroutineContext, useCase
            )

            businessViewModel.viewState().value shouldBeInstanceOf ViewState.Success::class
        }
    }

    @Test
    fun `empty business list is empty viewstate`() {
        runBlocking {
            val podcastRepository: PodcastRepository = mock()
            whenever(podcastRepository.getPodcasts(any())).doReturn(Success(listOf()))

            val useCase = DefaultGetPodcastUseCase(podcastRepository)

            val businessViewModel = PodcastViewModel(
                this@PodcastViewModelTest.coroutineContext, useCase
            )

            businessViewModel.viewState().value shouldBeInstanceOf ViewState.Empty::class
        }
    }
    @Test
    fun `network error throws is error viewstate`() {
        runBlocking {
            val podcastRepository: PodcastRepository = mock()
            whenever(podcastRepository.getPodcasts(any())).doReturn(
                Failure(UnknownNetworkException)
            )

            val useCase = DefaultGetPodcastUseCase(podcastRepository)

            val businessViewModel = PodcastViewModel(
                this@PodcastViewModelTest.coroutineContext, useCase
            )

            businessViewModel.viewState().value shouldBeInstanceOf ViewState.Error::class
        }
    }
}