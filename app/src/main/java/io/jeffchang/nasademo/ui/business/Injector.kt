package io.jeffchang.nasademo.ui.business

import io.jeffchang.nasademo.coreComponent
import io.jeffchang.nasademo.ui.business.di.DaggerBusinessComponent
import io.jeffchang.nasademo.ui.business.view.BusinessListFragment

// Injector for Business fragment.
fun BusinessListFragment.inject() {
    DaggerBusinessComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}

