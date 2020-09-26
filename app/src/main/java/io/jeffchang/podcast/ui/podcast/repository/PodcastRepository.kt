package io.jeffchang.podcast.ui.podcast.repository

import io.jeffchang.core.Result
import io.jeffchang.podcast.ui.podcast.data.model.podcastlist.PodcastItem


interface PodcastRepository {

    suspend fun getPodcasts(term: String): Result<List<PodcastItem>>

}
