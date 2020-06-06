package io.jeffchang.core.di

import androidx.fragment.app.Fragment

interface BaseComponent<T> {

    fun inject(target: T)
}

/**
 * Base dagger component for use in fragments.
 */
interface BaseFragmentComponent<T : Fragment> :
    BaseComponent<T>
