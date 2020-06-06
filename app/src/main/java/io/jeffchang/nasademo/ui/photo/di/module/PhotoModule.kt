package io.jeffchang.nasademo.ui.photo.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.di.ViewModelKey
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.nasademo.ui.photo.data.service.PhotoService
import io.jeffchang.nasademo.ui.photo.repository.PhotoRepository
import io.jeffchang.nasademo.ui.photo.usecase.GetMalformedPhotosUseCase
import io.jeffchang.nasademo.ui.photo.usecase.GetNASAPhotosUseCase
import io.jeffchang.nasademo.ui.photo.viewmodel.PhotoViewModel
import retrofit2.Retrofit

@Module
abstract class PhotoModule {

    @Binds
    @IntoMap
    @ViewModelKey(PhotoViewModel::class)
    abstract fun bindPhotoViewModel(viewModel: PhotoViewModel): ViewModel

}
