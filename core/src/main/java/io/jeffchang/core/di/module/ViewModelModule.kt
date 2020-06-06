package io.jeffchang.core.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.jeffchang.core.di.DaggerViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(
        factoryMapper: DaggerViewModelFactory
    ): ViewModelProvider.Factory
}
