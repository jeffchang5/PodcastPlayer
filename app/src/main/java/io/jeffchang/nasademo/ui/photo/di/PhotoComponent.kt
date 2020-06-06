package io.jeffchang.nasademo.ui.photo.di

import dagger.Component
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.di.BaseFragmentComponent
import io.jeffchang.core.di.module.ViewModelModule
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.nasademo.ui.photo.di.module.PhotoDataModule
import io.jeffchang.nasademo.ui.photo.view.PhotoFragment
import io.jeffchang.nasademo.ui.photo.di.module.PhotoModule

/**
 * Component binding injections for photo related classes
 */
@Component(
    modules = [ViewModelModule::class, PhotoModule::class, PhotoDataModule::class],
    dependencies = [CoreComponent::class]
)
@FeatureScope
interface PhotoComponent : BaseFragmentComponent<PhotoFragment> {

    @Component.Builder
    interface Builder {

        fun coreComponent(component: CoreComponent): Builder

        fun build(): PhotoComponent
    }
}
