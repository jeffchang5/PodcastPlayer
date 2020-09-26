package io.jeffchang.podcast.ui.podcast.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.jeffchang.podcast.R
import io.jeffchang.podcast.databinding.ItemPodcastBinding

import io.jeffchang.podcast.ui.podcast.data.model.podcastlist.PodcastItem

class PodcastListAdapter
    : ListAdapter<PodcastItem, PodcastListAdapter.PodcastViewHolder>(PodcastItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastViewHolder {
        val binding = ItemPodcastBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PodcastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PodcastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PodcastViewHolder(private val binding: ItemPodcastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(business: PodcastItem) {
            binding.apply {
                val context = root.context

                // Sets fields or use default values.
                titleTextView.text = business.titleOriginal ?: context.getText(R.string.missing_data)
                teamTextView.text = business.podcast?.publisherOriginal ?: context.getText(R.string.missing_data)

                // Binds image with placeholders or defaults.
                Glide.with(context)
                    .load(business.thumbnail)
                    .apply(
                        RequestOptions()
                            .error(R.drawable.ic_baseline_none_24)
                            .placeholder(R.color.placeholder)
                            .centerCrop()
                    )
                    .into(BusinessImageView)
            }
        }
    }

    private class PodcastItemCallback : DiffUtil.ItemCallback<PodcastItem>() {
        override fun areItemsTheSame(oldItem: PodcastItem, newItem: PodcastItem): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: PodcastItem, newItem: PodcastItem): Boolean =
            oldItem == newItem
    }
}
