package io.jeffchang.nasademo.ui.photo.usecase

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.photo.data.Photo
import io.jeffchang.nasademo.ui.photo.viewmodel.SortingStrategy


interface GetPhotosUseCase {

    suspend operator fun invoke(param: SortingStrategy): Result<List<Photo>>

}