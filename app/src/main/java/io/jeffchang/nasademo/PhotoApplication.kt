package io.jeffchang.nasademo

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.DaggerCoreComponent
import io.jeffchang.nasademo.component.DaggerAppComponent
import timber.log.Timber

class PhotoApplication : Application() {

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
            (context.applicationContext as PhotoApplication).coreComponent
    }
}

fun Activity.coreComponent() = PhotoApplication.coreComponent(this)

fun Fragment.coreComponent() = PhotoApplication.coreComponent(requireContext())