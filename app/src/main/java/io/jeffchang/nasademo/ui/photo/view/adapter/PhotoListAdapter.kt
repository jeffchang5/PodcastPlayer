package io.jeffchang.nasademo.ui.photo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.jeffchang.nasademo.R
import io.jeffchang.nasademo.databinding.ItemPhotoBinding
import io.jeffchang.nasademo.ui.photo.data.Photo

class PhotoListAdapter : ListAdapter<Photo, PhotoListAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.apply {
                titleTextView.text = photo.rover
                teamTextView.text = photo.notes

                Glide.with(root.context)
                    .load(photo.imgSrc)
                    .apply(
                        RequestOptions()
                            .error(R.drawable.ic_baseline_none_24)
                            .placeholder(R.color.placeholder)
                            .centerCrop()
                    )
                    .into(photoImageView)
            }
        }
    }

    private class PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem == newItem
    }
}
