package io.jeffchang.core.di.module

import dagger.Module
import dagger.Provides
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.DefaultContextProvider
import javax.inject.Singleton

@Module
class DispatcherModule {

    @Provides
    @Singleton
    fun provideDispatcher(): ContextProvider {
        return DefaultContextProvider()
    }
}
