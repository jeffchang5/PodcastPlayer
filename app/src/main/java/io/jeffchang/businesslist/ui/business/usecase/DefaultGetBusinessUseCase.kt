package io.jeffchang.businesslist.ui.business.usecase

import io.jeffchang.core.Result
import io.jeffchang.businesslist.ui.business.data.model.business.Business
import io.jeffchang.businesslist.ui.business.repository.BusinessRepository

class DefaultGetBusinessUseCase(private val businessRepository: BusinessRepository) : GetBusinessUseCase {

    override suspend fun invoke(term : String): Result<List<Business>> {
        return businessRepository.getBusinesses(term)
    }

}