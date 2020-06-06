package io.jeffchang.nasademo.ui.photo.data

import com.squareup.moshi.Json
import io.jeffchang.core.DomainMapper

data class Response(
    @Json(name = "photos")
    val photos: List<Photo>
) : DomainMapper<List<Photo>> {

    override fun mapToDomainModel(): List<Photo> = photos

}