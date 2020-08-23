package io.jeffchang.nasademo.ui.business.data.model.business

import com.squareup.moshi.Json

data class CategoriesItem(

	@Json(name="alias")
	val alias: String? = null,

	@Json(name="title")
	val title: String? = null
)