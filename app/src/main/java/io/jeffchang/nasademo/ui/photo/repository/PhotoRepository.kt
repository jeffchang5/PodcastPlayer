package io.jeffchang.nasademo.ui.photo.repository

import io.jeffchang.core.ContextProvider
import io.jeffchang.core.Result
import io.jeffchang.core.safeApiCall
import io.jeffchang.nasademo.ui.photo.data.Photo
import io.jeffchang.nasademo.ui.photo.data.service.PhotoService
import kotlinx.coroutines.withContext

class PhotoRepository(
    private val provider: ContextProvider,
    private val photoService: PhotoService
) {

    suspend fun getPhotos(): Result<List<Photo>> {
        return withContext(provider.io) {
            safeApiCall(photoService::getPhotos)
        }
    }

    suspend fun getPhotosWithMissingData(): Result<List<Photo>> {
        return withContext(provider.io) {
            safeApiCall(photoService::getPhotosWithMissingData)
        }
    }
}
