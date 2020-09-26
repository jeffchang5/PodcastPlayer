package io.jeffchang.podcast.ui.podcast.repository

import io.jeffchang.core.ContextProvider
import io.jeffchang.core.Result
import io.jeffchang.core.safeApiCall
import io.jeffchang.podcast.ui.podcast.data.model.podcastlist.PodcastItem
import io.jeffchang.podcast.ui.podcast.data.service.PodcastService
import kotlinx.coroutines.withContext

class ListenNotesPodcastRepository(
    private val provider: ContextProvider,
    private val podcastService: PodcastService
) : PodcastRepository {

    override suspend fun getPodcasts(term: String): Result<List<PodcastItem>> {
        return withContext(provider.io) {
            safeApiCall {
                podcastService.searchPodcasts(term)
            }
        }
    }
}