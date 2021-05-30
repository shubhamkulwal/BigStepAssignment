package com.assignment.bigstepassignment.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.assignment.bigstepassignment.data.entities.VideoDetails
import com.assignment.bigstepassignment.data.local.AppDatabase
import com.assignment.bigstepassignment.utils.Resource
import com.assignment.bigstepassignment.utils.Status
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HistoryRepository @Inject constructor(private val localDataSource: AppDatabase) {

    fun getItemVisited(): LiveData<Resource<List<VideoDetails>>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val source = localDataSource.videoDetailDao().getAllVideoVisited().map { Resource.success(it) }
        emitSource(source)
    }
}