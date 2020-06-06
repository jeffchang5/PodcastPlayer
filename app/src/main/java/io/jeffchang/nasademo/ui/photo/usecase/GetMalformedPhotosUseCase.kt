package io.jeffchang.nasademo.ui.photo.usecase

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.photo.data.Photo
import io.jeffchang.nasademo.ui.photo.repository.PhotoRepository


class GetMalformedPhotosUseCase(private val photoRepository: PhotoRepository) : GetPhotosUseCase {

    override suspend fun invoke(param: Unit): Result<List<Photo>> {
        return photoRepository.getPhotosWithMissingData()
    }

}