package com.assignment.bigstepassignment.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.assignment.bigstepassignment.data.entities.VideoDetails
import com.assignment.bigstepassignment.data.local.AppDatabase
import com.assignment.bigstepassignment.data.model.VideoListResponse
import com.assignment.bigstepassignment.data.remote.RemoteDataSource
import com.assignment.bigstepassignment.utils.Resource
import com.assignment.bigstepassignment.utils.Status
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class VideoRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: AppDatabase
) {

    fun getVideoList(queryMap: Map<String, String>): LiveData<Resource<VideoListResponse>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val responseStatus = remoteDataSource.getVideoList(queryMap)
            if (responseStatus.status == Status.SUCCESS)
                emit(Resource.success(responseStatus.data!!))
            else if (responseStatus.status == Status.ERROR)
                emit(Resource.error(responseStatus.message!!, null))
        }

    fun insertItemVisited(videoDetails: VideoDetails, scope: CoroutineScope) =
            scope.launch(Dispatchers.IO) {
            localDataSource.videoDetailDao().insert(videoDetails)
        }
}