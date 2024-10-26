package com.example.userprofileregistration_dipti_15.rep15


import androidx.lifecycle.LiveData
import com.example.userprofileregistration_dipti_15.dao15.UPDao15
import com.example.userprofileregistration_dipti_15.model15.UP15


class UPR15(private val uPD: UPDao15){
    fun getUP():LiveData<List<UP15>>{
        return uPD.getallprofile()
    }
    suspend fun insert(up: UP15){
        return uPD.insert(up)
    }

    suspend fun update(up: UP15){
        return uPD.update(up)
    }

    suspend fun delete(up: UP15){
        return uPD.delete(up)
    }
}
