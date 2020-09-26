package io.jeffchang.businesslist.ui.business.data.service

import io.jeffchang.businesslist.ui.business.data.model.business.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PodcastService {

    @GET("/api/v2/search")
    suspend fun searchPodcasts(
        @Query("q") term: String
    ): Response

}
