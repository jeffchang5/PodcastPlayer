package io.jeffchang.businesslist

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.DaggerCoreComponent
import io.jeffchang.businesslist.component.DaggerAppComponent
import timber.log.Timber

class BusinessListApplication : Application() {

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
            (context.applicationContext as BusinessListApplication).coreComponent
    }
}

fun Activity.coreComponent() = BusinessListApplication.coreComponent(this)

fun Fragment.coreComponent() = BusinessListApplication.coreComponent(requireContext())