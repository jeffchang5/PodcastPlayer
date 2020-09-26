package io.jeffchang.podcast.component

import dagger.Component
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.scope.AppScope
import io.jeffchang.podcast.PodcastApplication

@AppScope
@Component(dependencies = [CoreComponent::class])
interface AppComponent {

    fun inject(application: PodcastApplication)

    @Component.Builder
    interface Builder {

        fun coreComponent(coreComponent: CoreComponent): Builder

        fun build(): AppComponent
    }
}
