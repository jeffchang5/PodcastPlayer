package io.jeffchang.nasademo.ui.photo.usecase

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.photo.data.Photo


interface GetPhotosUseCase {

    suspend operator fun invoke(param: Unit): Result<List<Photo>>

}