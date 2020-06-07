package io.jeffchang.nasademo.ui.photo.data

import com.squareup.moshi.Json

data class Photo(
    @Json(name = "earth_date")
    val earthDate: String? = null,
    val notes: String? = null,
    @Json(name = "camera_type")
    val cameraType: String? = null,
    val id: String? = null,
    @Json(name = "rover")
    val rover: String? = null,
    @Json(name = "img_src")
    val imgSrc: String? = null
)
