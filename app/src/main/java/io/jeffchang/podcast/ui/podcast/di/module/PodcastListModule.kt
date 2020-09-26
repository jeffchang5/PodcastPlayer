package io.jeffchang.podcast.ui.podcast.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.jeffchang.core.di.ViewModelKey
import io.jeffchang.podcast.ui.podcast.viewmodel.PodcastViewModel

@Module
abstract class PodcastListModule {

    @Binds
    @IntoMap
    @ViewModelKey(PodcastViewModel::class)
    abstract fun bindBusinessViewModel(viewModel: PodcastViewModel): ViewModel

}
