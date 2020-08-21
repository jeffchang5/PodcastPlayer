package io.jeffchang.nasademo.ui.business.usecase

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.business.data.model.Business
import io.jeffchang.nasademo.ui.business.repository.BusinessRepository

class DefaultGetBusinessUseCase(private val businessRepository: BusinessRepository) : GetBusinessUseCase {

    override suspend fun invoke(): Result<List<Business>> {
        return businessRepository.getBusinesses()
    }

}