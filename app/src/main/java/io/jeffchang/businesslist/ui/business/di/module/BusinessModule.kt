package io.jeffchang.nasademo.ui.business.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.jeffchang.core.di.ViewModelKey
import io.jeffchang.nasademo.ui.business.viewmodel.BusinessViewModel

@Module
abstract class BusinessModule {

    @Binds
    @IntoMap
    @ViewModelKey(BusinessViewModel::class)
    abstract fun bindBusinessViewModel(viewModel: BusinessViewModel): ViewModel

}
