package io.jeffchang.nasademo.ui.business.data.model.business

import com.squareup.moshi.Json

data class Region(

	@Json(name="center")
	val center: Center? = null
)