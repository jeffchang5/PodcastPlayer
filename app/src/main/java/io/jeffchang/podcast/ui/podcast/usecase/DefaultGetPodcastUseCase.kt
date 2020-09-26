package io.jeffchang.podcast.ui.podcast.usecase

import io.jeffchang.podcast.ui.podcast.data.model.podcastlist.PodcastItem
import io.jeffchang.podcast.ui.podcast.repository.PodcastRepository
import io.jeffchang.core.Result

class DefaultGetPodcastUseCase(private val podcastRepository: PodcastRepository) :
    GetPodcastUseCase {

    override suspend fun invoke(term: String): Result<List<PodcastItem>> {
        return podcastRepository.getPodcasts(term)
    }

}