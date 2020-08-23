package io.jeffchang.businesslist.ui.business.repository

import io.jeffchang.core.ContextProvider
import io.jeffchang.core.Result
import io.jeffchang.core.safeApiCall
import io.jeffchang.businesslist.ui.business.data.model.business.Business
import io.jeffchang.businesslist.ui.business.data.service.BusinessService
import kotlinx.coroutines.withContext

class DefaultBusinessRepository(
    private val provider: ContextProvider,
    private val businessService: BusinessService
) : BusinessRepository {

    override suspend fun getBusinesses(term: String): Result<List<Business>> {
        return withContext(provider.io) {
            safeApiCall {
                businessService.getBusinesses(term)
            }
        }
    }
}