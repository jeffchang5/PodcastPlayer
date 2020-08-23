package io.jeffchang.businesslist.component

import dagger.Component
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.scope.AppScope
import io.jeffchang.businesslist.BusinessListApplication

@AppScope
@Component(dependencies = [CoreComponent::class])
interface AppComponent {

    fun inject(application: BusinessListApplication)

    @Component.Builder
    interface Builder {

        fun coreComponent(coreComponent: CoreComponent): Builder

        fun build(): AppComponent
    }
}
