package io.jeffchang.businesslist.ui.business.repository

import io.jeffchang.core.Result
import io.jeffchang.businesslist.ui.business.data.model.business.ResultsItem


interface PodcastRepository {

    suspend fun getPodcasts(term: String): Result<List<ResultsItem>>

}
