package io.jeffchang.nasademo.ui.business.di

import dagger.Component
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.di.BaseFragmentComponent
import io.jeffchang.core.di.module.ViewModelModule
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.nasademo.ui.business.di.module.BusinessDataModule
import io.jeffchang.nasademo.ui.business.view.BusinessListFragment
import io.jeffchang.nasademo.ui.business.di.module.BusinessModule

/**
 * Component binding injections for Business related classes
 */
@Component(
    modules = [ViewModelModule::class, BusinessModule::class, BusinessDataModule::class],
    dependencies = [CoreComponent::class]
)
@FeatureScope
interface BusinessComponent : BaseFragmentComponent<BusinessListFragment> {

    @Component.Builder
    interface Builder {

        fun coreComponent(component: CoreComponent): Builder

        fun build(): BusinessComponent
    }
}
