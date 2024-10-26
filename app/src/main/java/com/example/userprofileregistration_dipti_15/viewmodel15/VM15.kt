package com.example.userprofileregistration_dipti_15.viewmodel15

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.userprofileregistration_dipti_15.DB15.UDB15
import com.example.userprofileregistration_dipti_15.model15.UP15
import com.example.userprofileregistration_dipti_15.rep15.UPR15
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VM15(application: Application): AndroidViewModel(application){
    private val repository: UPR15
    init {
        val userPdao= UDB15.getdb(application).updao()
        repository = UPR15 (userPdao)
    }

    fun getUserProfiles(): LiveData<List<UP15>> {
        return repository.getUP()
    }

    fun insertUserProfile(up: UP15){
        viewModelScope.launch (Dispatchers.IO){
            repository.insert(up)
        }
    }
    fun updateUserProfile(up: UP15){
        viewModelScope.launch (Dispatchers.IO){
            repository.update(up)
        }
    }
    fun deletetUserProfile(up: UP15){
        viewModelScope.launch (Dispatchers.IO){
            repository.delete(up)
        }
    }
}