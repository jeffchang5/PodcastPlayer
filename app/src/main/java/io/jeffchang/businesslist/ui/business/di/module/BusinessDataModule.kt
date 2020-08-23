package io.jeffchang.businesslist.ui.business.di.module

import dagger.Module
import dagger.Provides
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.businesslist.ui.business.data.service.BusinessService
import io.jeffchang.businesslist.ui.business.repository.DefaultBusinessRepository
import io.jeffchang.businesslist.ui.business.repository.BusinessRepository
import io.jeffchang.businesslist.ui.business.usecase.DefaultGetBusinessUseCase
import retrofit2.Retrofit

@Module
class BusinessDataModule {
    @Provides
    @FeatureScope
    fun provideBusinessService(retrofit: Retrofit): BusinessService =
        retrofit.create(BusinessService::class.java)

    @Provides
    @FeatureScope
    fun provideBusinessRepository(
        contextProvider: ContextProvider,
        BusinessService: BusinessService
    ): BusinessRepository =
        DefaultBusinessRepository(contextProvider, BusinessService)

    @Provides
    @FeatureScope
    fun provideGetNASABusinesssUseCase(
        BusinessRepository: BusinessRepository
    ): DefaultGetBusinessUseCase = DefaultGetBusinessUseCase(BusinessRepository)

}
