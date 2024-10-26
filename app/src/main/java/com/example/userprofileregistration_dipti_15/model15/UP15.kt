package com.example.userprofileregistration_dipti_15.model15

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "userProfile")
data class UP15(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String="",
    val email:String="",
    val dob:String="",
    val dist:String="",
    val mobile:String="",
):Serializable
