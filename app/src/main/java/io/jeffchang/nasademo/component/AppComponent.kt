package io.jeffchang.nasademo.component

import dagger.Component
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.scope.AppScope
import io.jeffchang.nasademo.PhotoApplication

@AppScope
@Component(dependencies = [CoreComponent::class])
interface AppComponent {

    fun inject(application: PhotoApplication)

    @Component.Builder
    interface Builder {

        fun coreComponent(coreComponent: CoreComponent): Builder

        fun build(): AppComponent
    }
}
