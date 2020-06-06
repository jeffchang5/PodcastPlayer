package io.jeffchang.core

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import io.jeffchang.core.di.module.DispatcherModule
import io.jeffchang.core.di.module.NetworkModule
import io.jeffchang.core.di.module.ViewModelModule
import javax.inject.Singleton
import retrofit2.Retrofit

/**
 * Component that injects into Android members (e.g. Activities and Fragments) with various
 * modules that provide tasks such as networking and caching in a database.
 */
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DispatcherModule::class,
        ViewModelModule::class
    ]
)
interface CoreComponent {

    fun dispatcher(): ContextProvider

    fun retrofit(): Retrofit

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }
}
