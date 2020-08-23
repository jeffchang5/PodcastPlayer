package io.jeffchang.nasademo.ui.business.usecase

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.business.data.model.business.Business


interface GetBusinessUseCase {

    suspend operator fun invoke(term: String): Result<List<Business>>

}