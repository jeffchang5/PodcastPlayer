package io.jeffchang.nasademo.ui.photo.di.module

import dagger.Module
import dagger.Provides
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.nasademo.ui.photo.data.model.PhotoService
import io.jeffchang.nasademo.ui.photo.repository.DefaultPhotoRepository
import io.jeffchang.nasademo.ui.photo.repository.PhotoRepository
import io.jeffchang.nasademo.ui.photo.usecase.GetMalformedPhotosUseCase
import io.jeffchang.nasademo.ui.photo.usecase.GetNASAPhotosUseCase
import retrofit2.Retrofit

@Module
class PhotoDataModule {
    @Provides
    @FeatureScope
    fun providePhotoService(retrofit: Retrofit): PhotoService =
        retrofit.create(PhotoService::class.java)

    @Provides
    @FeatureScope
    fun providePhotoRepository(
        contextProvider: ContextProvider,
        photoService: PhotoService
    ): PhotoRepository =
        DefaultPhotoRepository(contextProvider, photoService)

    @Provides
    @FeatureScope
    fun provideGetNASAPhotosUseCase(
        photoRepository: PhotoRepository
    ): GetNASAPhotosUseCase = GetNASAPhotosUseCase(photoRepository)

    @Provides
    @FeatureScope
    fun provideGetMalformedPhotosUseCase(
        photoRepository: PhotoRepository
    ): GetMalformedPhotosUseCase = GetMalformedPhotosUseCase(photoRepository)
}
