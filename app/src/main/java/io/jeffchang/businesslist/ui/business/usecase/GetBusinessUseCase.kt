package io.jeffchang.businesslist.ui.business.usecase

import io.jeffchang.core.Result
import io.jeffchang.businesslist.ui.business.data.model.business.Business


interface GetBusinessUseCase {

    suspend operator fun invoke(term: String): Result<List<Business>>

}