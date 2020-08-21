package io.jeffchang.nasademo.ui.business.repository

import io.jeffchang.core.ContextProvider
import io.jeffchang.core.Result
import io.jeffchang.core.safeApiCall
import io.jeffchang.nasademo.ui.business.data.model.Business
import io.jeffchang.nasademo.ui.business.data.service.BusinessService
import kotlinx.coroutines.withContext

class DefaultBusinessRepository(
    private val provider: ContextProvider,
    private val businessService: BusinessService
) : BusinessRepository {

    override suspend fun getBusinesses(): Result<List<Business>> {
        return withContext(provider.io) {
            safeApiCall(businessService::getBusinesses)
        }
    }

}