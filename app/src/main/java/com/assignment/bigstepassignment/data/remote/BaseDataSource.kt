package com.assignment.bigstepassignment.data.remote

import com.assignment.bigstepassignment.utils.Resource
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>?): Resource<T> {
        try {
            val response = call()
            response?.let {
                if (it.isSuccessful){
                    val body = it.body()
                    if (body != null) return Resource.success(body)
                }
            }
            return error(" ${response?.code()} ${response?.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message")
    }
}