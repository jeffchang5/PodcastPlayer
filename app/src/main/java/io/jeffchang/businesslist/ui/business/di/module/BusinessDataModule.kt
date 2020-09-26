package io.jeffchang.businesslist.ui.business.di.module

import dagger.Module
import dagger.Provides
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.businesslist.ui.business.data.service.PodcastService
import io.jeffchang.businesslist.ui.business.repository.ListenNotesPodcastRepository
import io.jeffchang.businesslist.ui.business.repository.PodcastRepository
import io.jeffchang.businesslist.ui.business.usecase.DefaultGetPodcastUseCase
import io.jeffchang.businesslist.ui.business.usecase.GetPodcastUseCase
import retrofit2.Retrofit

@Module
class BusinessDataModule {
    @Provides
    @FeatureScope
    fun provideBusinessService(retrofit: Retrofit): PodcastService =
        retrofit.create(PodcastService::class.java)

    @Provides
    @FeatureScope
    fun provideBusinessRepository(
        contextProvider: ContextProvider,
        PodcastService: PodcastService
    ): PodcastRepository =
        ListenNotesPodcastRepository(contextProvider, PodcastService)

    @Provides
    @FeatureScope
    fun provideGetNASABusinesssUseCase(
        PodcastRepository: PodcastRepository
    ): GetPodcastUseCase = DefaultGetPodcastUseCase(PodcastRepository)

}
