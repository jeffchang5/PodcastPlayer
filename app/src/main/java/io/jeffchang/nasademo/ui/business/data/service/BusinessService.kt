package io.jeffchang.nasademo.ui.business.data.service

import io.jeffchang.nasademo.ui.business.data.model.Response
import retrofit2.http.GET

interface BusinessService {

    @GET("mars.json")
    suspend fun getBusinesses(): Response

}
