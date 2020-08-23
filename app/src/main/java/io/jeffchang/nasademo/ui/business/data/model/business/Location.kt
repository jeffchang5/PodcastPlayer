package io.jeffchang.nasademo.ui.business.data.model.business

import com.squareup.moshi.Json

data class Location(

	@Json(name="country")
	val country: String? = null,

	@Json(name="address3")
	val address3: String? = null,

	@Json(name="city")
	val city: String? = null,

	@Json(name="address2")
	val address2: String? = null,

	@Json(name="address1")
	val address1: String? = null,

	@Json(name="state")
	val state: String? = null,

	@Json(name="zip_code")
	val zipCode: String? = null
)