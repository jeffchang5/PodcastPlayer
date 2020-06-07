package io.jeffchang.nasademo.ui.photo.repository

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.photo.data.model.Photo


interface PhotoRepository {

    suspend fun getPhotos(): Result<List<Photo>>

    suspend fun getPhotosWithMissingData(): Result<List<Photo>>

}
