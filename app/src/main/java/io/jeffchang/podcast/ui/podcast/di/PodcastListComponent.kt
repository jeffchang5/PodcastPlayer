package io.jeffchang.podcast.ui.podcast.di

import dagger.Component
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.di.BaseFragmentComponent
import io.jeffchang.core.di.module.ViewModelModule
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.podcast.ui.podcast.di.module.PodcastListDataModule
import io.jeffchang.podcast.ui.podcast.view.PodcastListFragment
import io.jeffchang.podcast.ui.podcast.di.module.PodcastListModule

/**
 * Component binding injections for podcast list related classes
 */
@Component(
    modules = [ViewModelModule::class, PodcastListModule::class, PodcastListDataModule::class],
    dependencies = [CoreComponent::class]
)
@FeatureScope
interface PodcastListComponent : BaseFragmentComponent<PodcastListFragment> {

    @Component.Builder
    interface Builder {

        fun coreComponent(component: CoreComponent): Builder

        fun build(): PodcastListComponent
    }
}
