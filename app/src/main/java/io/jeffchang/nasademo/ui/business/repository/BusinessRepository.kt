package io.jeffchang.nasademo.ui.business.repository

import io.jeffchang.core.Result
import io.jeffchang.nasademo.ui.business.data.model.Business


interface BusinessRepository {

    suspend fun getBusinesses(): Result<List<Business>>

}
