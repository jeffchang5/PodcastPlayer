package io.jeffchang.nasademo.ui.photo.di

import io.jeffchang.nasademo.PhotoFragment
import io.jeffchang.nasademo.coreComponent

fun PhotoFragment.inject() {
    DaggerPhotoComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}
