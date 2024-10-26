package com.example.userprofileregistration_dipti_15.dao15

import androidx.lifecycle.LiveData
import androidx.room.Dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.userprofileregistration_dipti_15.model15.UP15

@Dao
interface UPDao15 {
    @Insert
    suspend fun  insert(up: UP15)

    @Update
    suspend fun  update(up: UP15)

    @Delete
    suspend fun  delete(up: UP15)

    @Query("SELECT * FROM userProfile")

    fun getallprofile():LiveData<List<UP15>>



}