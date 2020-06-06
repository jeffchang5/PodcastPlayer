package io.jeffchang.nasademo.ui.photo.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.jeffchang.core.di.ViewModelKey
import io.jeffchang.nasademo.ui.photo.viewmodel.PhotoViewModel

@Module
abstract class PhotoModule {

    @Binds
    @IntoMap
    @ViewModelKey(PhotoViewModel::class)
    abstract fun bindEmployeeViewModel(viewModel: PhotoViewModel): ViewModel
}
