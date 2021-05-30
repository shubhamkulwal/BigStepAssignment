package com.assignment.bigstepassignment.data.remote

import com.assignment.bigstepassignment.data.model.VideoListResponse
import com.assignment.bigstepassignment.utils.Constants
import com.assignment.bigstepassignment.utils.Constants.GET_METHOD
import com.assignment.bigstepassignment.utils.Constants.POST_METHOD
import com.assignment.bigstepassignment.utils.Constants.SEARCH
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET(SEARCH)
    suspend fun getVideoList(@QueryMap queryMap: Map<String, String>?): Response<VideoListResponse>
}