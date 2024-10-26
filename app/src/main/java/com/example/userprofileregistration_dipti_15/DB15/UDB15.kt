package com.example.userprofileregistration_dipti_15.DB15

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userprofileregistration_dipti_15.dao15.UPDao15
import com.example.userprofileregistration_dipti_15.model15.UP15


@Database(entities = [UP15::class], version = 1)
abstract class UDB15:RoomDatabase() {
    abstract fun updao(): UPDao15

    companion object{

        @Volatile
        private var INSTENSE:UDB15?=null

        fun getdb(context:Context):UDB15{
            return INSTENSE?: synchronized(this){
                val ins= Room.databaseBuilder(
                    context.applicationContext,
                    UDB15::class.java,
                    "UserProfileDB"
                ).build()
                INSTENSE=ins
                ins
            }
        }
    }
}