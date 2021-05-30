package com.assignment.bigstepassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.assignment.bigstepassignment.R
import com.assignment.bigstepassignment.data.entities.VideoDetails
import com.assignment.bigstepassignment.databinding.AdapterVideoListBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class HistoryListRecyclerAdapter : RecyclerView.Adapter<HistoryListRecyclerAdapter.HistoryListViewHolder>() {

    private val items = ArrayList<VideoDetails>()

    fun setItems(items: ArrayList<VideoDetails>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryListViewHolder {
        val binding = DataBindingUtil.inflate<AdapterVideoListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_video_list,
            parent,
            false
        )
        return HistoryListViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: HistoryListViewHolder, position: Int) =
        holder.bind(items[position])

    inner class HistoryListViewHolder(private val binding: AdapterVideoListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: VideoDetails) {
            Glide.with(binding.root)
                .load(item.artworkUrl100)
                .transform(RoundedCorners(20))
                .into(binding.thumbnailIv)
            binding.item = item
            binding.executePendingBindings()
        }
    }
}