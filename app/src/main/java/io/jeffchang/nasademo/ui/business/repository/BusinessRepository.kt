package io.jeffchang.nasademo.ui.business.repository

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.business.data.model.business.Business


interface BusinessRepository {

    suspend fun getBusinesses(term: String): Result<List<Business>>

}
