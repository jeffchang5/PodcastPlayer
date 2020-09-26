package io.jeffchang.podcast.ui.podcast.di.module

import dagger.Module
import dagger.Provides
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.podcast.ui.podcast.data.service.PodcastService
import io.jeffchang.podcast.ui.podcast.repository.ListenNotesPodcastRepository
import io.jeffchang.podcast.ui.podcast.repository.PodcastRepository
import io.jeffchang.podcast.ui.podcast.usecase.DefaultGetPodcastUseCase
import io.jeffchang.podcast.ui.podcast.usecase.GetPodcastUseCase
import retrofit2.Retrofit

@Module
class PodcastListDataModule {
    @Provides
    @FeatureScope
    fun providePodcastListService(retrofit: Retrofit): PodcastService =
        retrofit.create(PodcastService::class.java)

    @Provides
    @FeatureScope
    fun providePodcastListRepository(
        contextProvider: ContextProvider,
        PodcastService: PodcastService
    ): PodcastRepository =
        ListenNotesPodcastRepository(contextProvider, PodcastService)

    @Provides
    @FeatureScope
    fun providePodcastListUseCase(
        PodcastRepository: PodcastRepository
    ): GetPodcastUseCase = DefaultGetPodcastUseCase(PodcastRepository)

}
