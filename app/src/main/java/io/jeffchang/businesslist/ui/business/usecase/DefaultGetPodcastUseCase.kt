package io.jeffchang.businesslist.ui.business.usecase

import io.jeffchang.businesslist.ui.business.data.model.business.ResultsItem
import io.jeffchang.businesslist.ui.business.repository.PodcastRepository
import io.jeffchang.core.Result

class DefaultGetPodcastUseCase(private val podcastRepository: PodcastRepository) :
    GetPodcastUseCase {

    override suspend fun invoke(term: String): Result<List<ResultsItem>> {
        return podcastRepository.getPodcasts(term)
    }

}