package io.jeffchang.businesslist.ui.business.usecase

import io.jeffchang.businesslist.ui.business.data.model.business.ResultsItem
import io.jeffchang.core.Result


interface GetPodcastUseCase {

    suspend operator fun invoke(term: String): Result<List<ResultsItem>>

}