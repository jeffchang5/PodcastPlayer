package io.jeffchang.nasademo.ui.business.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.jeffchang.nasademo.R
import io.jeffchang.nasademo.databinding.ItemBusinessBinding
import io.jeffchang.nasademo.ui.business.data.model.Business

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
                titleTextView.text = business.rover ?: context.getText(R.string.missing_data)
                teamTextView.text = business.notes ?: context.getText(R.string.missing_data)

                // Binds image with placeholders or defaults.
                Glide.with(context)
                    .load(business.imgSrc)
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
