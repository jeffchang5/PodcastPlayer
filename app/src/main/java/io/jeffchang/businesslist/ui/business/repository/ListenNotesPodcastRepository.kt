package io.jeffchang.businesslist.ui.business.repository

import io.jeffchang.core.ContextProvider
import io.jeffchang.core.Result
import io.jeffchang.core.safeApiCall
import io.jeffchang.businesslist.ui.business.data.model.business.ResultsItem
import io.jeffchang.businesslist.ui.business.data.service.PodcastService
import kotlinx.coroutines.withContext

class ListenNotesPodcastRepository(
    private val provider: ContextProvider,
    private val podcastService: PodcastService
) : PodcastRepository {

    override suspend fun getPodcasts(term: String): Result<List<ResultsItem>> {
        return withContext(provider.io) {
            safeApiCall {
                podcastService.searchPodcasts(term)
            }
        }
    }
}