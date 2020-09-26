package io.jeffchang.podcast.ui.podcast.repository

import com.nhaarman.mockitokotlin2.*
import io.jeffchang.podcast.ui.podcast.data.model.podcastlist.Response2
import io.jeffchang.podcast.ui.podcast.data.service.PodcastService
import io.jeffchang.core.Failure
import io.jeffchang.core.Success
import io.jeffchang.core.TestContextProvider
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import retrofit2.HttpException

class PodcastRepositoryTest {

    private val podcastService: PodcastService = mock()

    private val businessRepository = ListenNotesPodcastRepository(
        TestContextProvider(),
        podcastService
    )

    @Test
    fun `getBusinesses returns list of businesses upon success`() {
        runBlocking {
            // Given

            // When
            whenever(podcastService.searchPodcasts(any(), any())).doReturn(
                Response2(
                    total = 1,
                    region = Region(),
                    businesses = listOf(
                        Business()
                    )
                )
            )
            val result = businessRepository.getPodcasts("Los Angeles")

            // Then
            result shouldBeInstanceOf Success::class
            verify(podcastService, times(1)).searchPodcasts(any(), any())
        }
    }

    @Test
    fun `getBusinesses on http exception returns failure`() {
        runBlocking {
            // Given

            // When
            whenever(podcastService.searchPodcasts(any(), any())).thenThrow(
                HttpException(
                    retrofit2.Response.error<Response2>(
                        404, ResponseBody.create(null, "")
                    )
                )
            )
            val result = businessRepository.getPodcasts("Los Angeles")

            // Then
            result shouldBeInstanceOf Failure::class
            verify(podcastService, times(1)).searchPodcasts(any(), any())
        }
    }

}