package io.jeffchang.businesslist.ui.business.repository

import io.jeffchang.core.Result
import io.jeffchang.businesslist.ui.business.data.model.business.Business


interface BusinessRepository {

    suspend fun getBusinesses(term: String): Result<List<Business>>

}
