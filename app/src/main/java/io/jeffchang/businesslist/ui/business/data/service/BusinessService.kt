package io.jeffchang.businesslist.ui.business.data.service

import io.jeffchang.businesslist.ui.business.data.model.business.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BusinessService {

    @GET("/v3/businesses/search")
    suspend fun getBusinesses(
        @Query("term") term: String,
        @Query("location") location: String = "Los Angeles"
    ): Response

}
