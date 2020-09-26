package io.jeffchang.podcast

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import io.jeffchang.podcast.BuildConfig
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.DaggerCoreComponent
import io.jeffchang.podcast.component.DaggerAppComponent
import timber.log.Timber

class PodcastApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        inject()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun inject() {
        DaggerAppComponent.builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as PodcastApplication).coreComponent
    }
}

fun Activity.coreComponent() = PodcastApplication.coreComponent(this)

fun Fragment.coreComponent() = PodcastApplication.coreComponent(requireContext())