package io.jeffchang.podcast.ui.podcast

import io.jeffchang.podcast.coreComponent
import io.jeffchang.podcast.ui.podcast.di.DaggerPodcastListComponent

import io.jeffchang.podcast.ui.podcast.view.PodcastListFragment

// Injector for Business fragment.
fun PodcastListFragment.inject() {
    DaggerPodcastListComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}

