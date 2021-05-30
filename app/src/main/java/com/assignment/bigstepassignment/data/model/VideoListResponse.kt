package com.assignment.bigstepassignment.data.model

import com.assignment.bigstepassignment.data.entities.VideoDetails
import com.google.gson.annotations.SerializedName

data class VideoListResponse(
    @SerializedName("resultCount")
    var resultCount: Int,
    @SerializedName("results")
    var results: ArrayList<VideoDetails>
)