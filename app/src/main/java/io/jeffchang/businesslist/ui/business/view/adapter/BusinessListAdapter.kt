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
import io.jeffchang.businesslist.ui.business.data.model.business.Business

class BusinessListAdapter
    : ListAdapter<Business, BusinessListAdapter.BusinessViewHolder>(BusinessDiffCallback()) {

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

        fun bind(business: Business) {
            binding.apply {
                val context = root.context

                // Sets fields or use default values.
                titleTextView.text = business.name ?: context.getText(R.string.missing_data)
                teamTextView.text = business.alias ?: context.getText(R.string.missing_data)

                // Binds image with placeholders or defaults.
                Glide.with(context)
                    .load(business.imageUrl)
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

    private class BusinessDiffCallback : DiffUtil.ItemCallback<Business>() {
        override fun areItemsTheSame(oldItem: Business, newItem: Business): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Business, newItem: Business): Boolean =
            oldItem == newItem
    }
}
