package com.assignment.bigstepassignment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.assignment.bigstepassignment.data.entities.VideoDetails

@Dao
interface VideoDetailDao {

    @Query("SELECT * FROM VideoDetails")
    fun getAllVideoVisited() : LiveData<List<VideoDetails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(videoDetail: VideoDetails): Long
}