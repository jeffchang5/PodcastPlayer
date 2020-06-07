package io.jeffchang.nasademo.ui.photo.usecase

import io.jeffchang.core.Result
import io.jeffchang.core.Success
import io.jeffchang.nasademo.ui.photo.data.Photo
import io.jeffchang.nasademo.ui.photo.repository.PhotoRepository
import io.jeffchang.nasademo.ui.photo.viewmodel.SortingStrategy


class GetMalformedPhotosUseCase(private val photoRepository: PhotoRepository) : GetPhotosUseCase {

    override suspend fun invoke(param: SortingStrategy): Result<List<Photo>> {
        val photos = photoRepository.getPhotosWithMissingData()

        // Sorts and organizes list by sorting strategy and maps it to a property of the object.
        if (photos is Success) {
            val sortedList = photos.data.sortedBy { photo ->
                when (param) {
                    SortingStrategy.EARTH_DATE -> {
                        photo.earthDate
                    }
                    SortingStrategy.CAMERA_TYPE -> {
                        photo.cameraType
                    }
                    SortingStrategy.ROVER -> {
                        photo.rover
                    }
                }
            }
            return Success(sortedList)
        }
        return photos
    }

}