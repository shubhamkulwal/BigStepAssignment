package com.assignment.bigstepassignment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.bigstepassignment.data.entities.VideoDetails
import com.assignment.bigstepassignment.data.model.VideoListResponse
import com.assignment.bigstepassignment.data.repository.VideoRepository
import com.assignment.bigstepassignment.utils.NetworkHelper
import com.assignment.bigstepassignment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val mRepository: VideoRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val videoListLiveData = MutableLiveData<Resource<VideoListResponse>>()

    fun getVideoList() : LiveData<Resource<VideoListResponse>> {
        if (networkHelper.isNetworkConnected()) {
            val queryMap = HashMap<String, String>().apply {
                put("term", "Michael+jackson")
                put("media", "musicVideo")
            }
            return mRepository.getVideoList(queryMap)
        }else videoListLiveData.value = Resource.error(
            "please check your internet connection",
            null
        )
        return videoListLiveData
    }

    fun insertItemVisited(item: VideoDetails) = mRepository.insertItemVisited(item, viewModelScope)
}