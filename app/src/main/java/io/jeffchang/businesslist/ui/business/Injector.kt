package io.jeffchang.businesslist.ui.business

import io.jeffchang.businesslist.coreComponent
import io.jeffchang.businesslist.ui.business.di.DaggerBusinessComponent
import io.jeffchang.businesslist.ui.business.view.BusinessListFragment

// Injector for Business fragment.
fun BusinessListFragment.inject() {
    DaggerBusinessComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}

