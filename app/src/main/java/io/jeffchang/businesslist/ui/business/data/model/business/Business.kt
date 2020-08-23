package io.jeffchang.nasademo.ui.business.data.model.business

import com.squareup.moshi.Json

data class Business(

    @Json(name="distance")
	val distance: Double? = null,

    @Json(name="image_url")
	val imageUrl: String? = null,

    @Json(name="rating")
	val rating: Double? = null,

    @Json(name="coordinates")
	val coordinates: Coordinates? = null,

    @Json(name="review_count")
	val reviewCount: Int? = null,

    @Json(name="transactions")
	val transactions: List<String?>? = null,

    @Json(name="url")
	val url: String? = null,

    @Json(name="phone")
	val phone: String? = null,

    @Json(name="price")
	val price: String? = null,

    @Json(name="name")
	val name: String? = null,

    @Json(name="alias")
	val alias: String? = null,

    @Json(name="location")
	val location: Location? = null,

    @Json(name="id")
	val id: String? = null,

    @Json(name="categories")
	val categories: List<CategoriesItem?>? = null,

    @Json(name="is_closed")
	val isClosed: Boolean? = null
)