package io.jeffchang.nasademo.ui.business.usecase

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.business.data.model.Business


interface GetBusinessUseCase {

    suspend operator fun invoke(): Result<List<Business>>

}