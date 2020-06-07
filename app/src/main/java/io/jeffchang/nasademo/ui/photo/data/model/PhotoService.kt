package io.jeffchang.nasademo.ui.photo.data.model

import io.jeffchang.nasademo.ui.photo.data.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("mars.json")
    suspend fun getPhotos(): Response

    @GET("https://gist.githubusercontent.com/jeffchang5/566b1d351cfea6f16b4acdc96e524169/raw/c1f815b0ab1cb7f63a08dd7d930d0b90e5f7b71b/mars_missing.json")
    suspend fun getPhotosWithMissingData(): Response

}
