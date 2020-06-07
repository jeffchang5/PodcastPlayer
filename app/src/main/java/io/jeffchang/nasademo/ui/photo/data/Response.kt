package io.jeffchang.nasademo.ui.photo.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.jeffchang.core.DomainMapper
import io.jeffchang.nasademo.ui.photo.data.model.Photo

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "photos")
    val photos: List<Photo>
) : DomainMapper<List<Photo>> {

    override fun mapToDomainModel(): List<Photo> = photos

}