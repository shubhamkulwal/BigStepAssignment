package com.assignment.bigstepassignment.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiInterface: ApiInterface) :
    BaseDataSource() {

    suspend fun getVideoList(queryMap: Map<String, String>) = getResult { apiInterface.getVideoList(queryMap) }
}