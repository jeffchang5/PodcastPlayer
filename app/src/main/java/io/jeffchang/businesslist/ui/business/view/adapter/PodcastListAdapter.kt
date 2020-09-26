package io.jeffchang.businesslist.ui.business.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.jeffchang.businesslist.R
import io.jeffchang.businesslist.databinding.ItemBusinessBinding
import io.jeffchang.businesslist.ui.business.data.model.business.ResultsItem

class PodcastListAdapter
    : ListAdapter<ResultsItem, PodcastListAdapter.BusinessViewHolder>(BusinessDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val binding = ItemBusinessBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BusinessViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BusinessViewHolder(private val binding: ItemBusinessBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(business: ResultsItem) {
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

    private class BusinessDiffCallback : DiffUtil.ItemCallback<ResultsItem>() {
        override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean =
            oldItem == newItem
    }
}
