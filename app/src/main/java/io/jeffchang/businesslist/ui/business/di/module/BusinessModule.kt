package io.jeffchang.businesslist.ui.business.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.jeffchang.core.di.ViewModelKey
import io.jeffchang.businesslist.ui.business.viewmodel.PodcastViewModel

@Module
abstract class BusinessModule {

    @Binds
    @IntoMap
    @ViewModelKey(PodcastViewModel::class)
    abstract fun bindBusinessViewModel(viewModel: PodcastViewModel): ViewModel

}
