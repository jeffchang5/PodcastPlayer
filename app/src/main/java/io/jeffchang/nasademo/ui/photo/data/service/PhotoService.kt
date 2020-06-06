package io.jeffchang.nasademo.ui.photo.data.service

import io.jeffchang.nasademo.ui.photo.data.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("mars.json")
    suspend fun getPhotos(): Response

    @GET("mars-missing.json")
    suspend fun getPhotosWithMissingData(): Response

}
