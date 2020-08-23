package io.jeffchang.businesslist.ui.business.data.model.business

import com.squareup.moshi.Json

data class Center(

	@Json(name="latitude")
	val latitude: Double,

	@Json(name="longitude")
	val longitude: Double
)