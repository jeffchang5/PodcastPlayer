package io.jeffchang.podcast.ui.podcast.data.service

import io.jeffchang.podcast.ui.podcast.data.model.podcastlist.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PodcastService {

    @GET("/api/v2/search")
    suspend fun searchPodcasts(
        @Query("q") term: String
    ): Response

}
