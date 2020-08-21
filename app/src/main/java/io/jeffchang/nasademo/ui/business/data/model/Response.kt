package io.jeffchang.nasademo.ui.business.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.jeffchang.core.DomainMapper

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "Businesss")
    val businesses: List<Business>
) : DomainMapper<List<Business>> {

    override fun mapToDomainModel(): List<Business> = businesses

}