package com.assignment.bigstepassignment.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.assignment.bigstepassignment.R
import com.assignment.bigstepassignment.data.entities.VideoDetails
import com.assignment.bigstepassignment.databinding.ActivityVideoDetailsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target


class VideoDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoDetailsBinding
    companion object {
        private const val ARG_VIDEO_DETAIL = "arg_video_detail"
        fun getIntent(context: Context, videoDetail: VideoDetails): Intent =
            Intent(context, VideoDetailsActivity::class.java).apply {
                putExtra(ARG_VIDEO_DETAIL, videoDetail)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_video_details)
        init()
    }

    private fun init(){
        binding.videoDetail = intent?.getSerializableExtra(ARG_VIDEO_DETAIL) as VideoDetails
    }
}

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).into(view)
}