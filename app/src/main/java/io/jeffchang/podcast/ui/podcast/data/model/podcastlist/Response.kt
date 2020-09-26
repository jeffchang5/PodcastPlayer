package io.jeffchang.podcast.ui.podcast.data.model.podcastlist

import com.squareup.moshi.Json
import io.jeffchang.core.DomainMapper

data class Response(
	val took: Double? = null,
	val total: Int? = null,
	val count: Int? = null,
	val nextOffset: Int? = null,
	val results: List<PodcastItem>
) : DomainMapper<List<PodcastItem>> {

	override fun mapToDomainModel(): List<PodcastItem> {
		return results
	}
}

data class PodcastItem(
	val image: String? = null,
	val thumbnail: String? = null,
	@Json(name = "description_original")
	val descriptionOriginal: String? = null,
	val itunesId: Int? = null,
	val explicitContent: Boolean? = null,
	val audioLengthSec: Int? = null,
	val link: String? = null,
	val listennotesUrl: String? = null,
	val titleHighlighted: String? = null,
	@Json(name = "title_original")
	val titleOriginal: String? = null,
	val rss: String? = null,
	val descriptionHighlighted: String? = null,
	val podcast: Podcast,
	val audio: String? = null,
	val id: String? = null,
	val pubDateMs: Long? = null,
	val transcriptsHighlighted: List<Any?>? = null
)

data class Podcast(
	val titleHighlighted: String? = null,
	val titleOriginal: String? = null,
	val image: String? = null,
	val thumbnail: String? = null,
	@Json(name = "publisher_original")
	val publisherOriginal: String? = null,
	@Json(name = "publisher_highlighted")
	val publisherHighlighted: String? = null,
	val id: String? = null,
	val genreIds: List<Int?>? = null,
	val listennotesUrl: String? = null
)

