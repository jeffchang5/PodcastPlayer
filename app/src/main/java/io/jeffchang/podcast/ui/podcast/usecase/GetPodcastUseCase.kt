package io.jeffchang.podcast.ui.podcast.usecase

import io.jeffchang.podcast.ui.podcast.data.model.podcastlist.PodcastItem
import io.jeffchang.core.Result


interface GetPodcastUseCase {

    suspend operator fun invoke(term: String): Result<List<PodcastItem>>

}