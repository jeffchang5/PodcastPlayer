package io.jeffchang.nasademo.ui.photo.repository

import io.jeffchang.core.ContextProvider
import io.jeffchang.core.Result
import io.jeffchang.core.safeApiCall
import io.jeffchang.nasademo.ui.photo.data.model.Photo
import io.jeffchang.nasademo.ui.photo.data.model.PhotoService
import kotlinx.coroutines.withContext

class DefaultPhotoRepository(
    private val provider: ContextProvider,
    private val photoService: PhotoService
) : PhotoRepository {

    override suspend fun getPhotos(): Result<List<Photo>> {
        return withContext(provider.io) {
            safeApiCall(photoService::getPhotos)
        }
    }

    override suspend fun getPhotosWithMissingData(): Result<List<Photo>> {
        return withContext(provider.io) {
            safeApiCall(photoService::getPhotosWithMissingData)
        }
    }
}