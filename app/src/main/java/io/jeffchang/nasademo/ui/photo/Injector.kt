package io.jeffchang.nasademo.ui.photo;

import io.jeffchang.nasademo.coreComponent
import io.jeffchang.nasademo.ui.photo.di.DaggerPhotoComponent
import io.jeffchang.nasademo.ui.photo.view.PhotoFragment

fun PhotoFragment.inject() {
    DaggerPhotoComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}

