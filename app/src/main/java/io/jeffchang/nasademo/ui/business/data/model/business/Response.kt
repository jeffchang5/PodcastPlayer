package io.jeffchang.nasademo.ui.business.data.model.business

import com.squareup.moshi.Json
import io.jeffchang.core.DomainMapper

data class Response(

	@Json(name="total")
	val total: Int,

	@Json(name="region")
	val region: Region,

	@Json(name="businesses")
	val businesses: List<Business>
): DomainMapper<List<Business>> {

	override fun mapToDomainModel(): List<Business> {
		return businesses
	}
}
