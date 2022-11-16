package com.clcmo.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.clcmo.data.local.model.AndroidJobCache
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

@Dao
interface JobsDAO {

    @Query("SELECT * FROM jobs")
    fun getJobs(): Flow<List<AndroidJobCache>>

    @Transaction
    fun updateData(users: List<AndroidJobCache>) {
        deleteAll()
        insertAll(users)
    }

    @Insert
    fun insertAll(users: List<AndroidJobCache>)

    @Insert
    fun insert(vararg job: AndroidJobCache)

    @Query("DELETE FROM jobs")
    fun deleteAll()
}