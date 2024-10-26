package com.example.userprofileregistration_dipti_15

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration_dipti_15.model15.UP15
import com.example.userprofileregistration_dipti_15.viewmodel15.VM15


class UpdateProfileActivity15 : AppCompatActivity() {
    private lateinit var profileViewModel: VM15
    private lateinit var userProfile: UP15

    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var dobEt: EditText
    private lateinit var districtEt: EditText
    private lateinit var mobileEt: EditText
    private lateinit var updateBtn: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile15)

        profileViewModel=ViewModelProvider(this).get(VM15::class.java)
        userProfile=intent.getSerializableExtra("User_Profile") as UP15

        nameEt=findViewById(R.id.nameet)
        emailEt=findViewById(R.id.emailet)
        dobEt=findViewById(R.id.dobet)
        districtEt=findViewById(R.id.diset)
        mobileEt=findViewById(R.id.mobileet)

        updateBtn=findViewById(R.id.upbtn)

        populatedFields()

        updateBtn.setOnClickListener{
            updateUserProfile()
        }
    }

    private fun updateUserProfile() {
        val name=nameEt.text.toString().trim()
        val email=emailEt.text.toString().trim()
        val dob=dobEt.text.toString().trim()
        val district=districtEt.text.toString().trim()
        val mobile=mobileEt.text.toString().trim()

        val userProfile= UP15(id =userProfile.id, name = name, email = email, dob=dob, dist=district, mobile= mobile)
        profileViewModel.updateUserProfile(userProfile)
        finish()
    }

    private fun populatedFields() {
        nameEt.setText(userProfile.name)
        emailEt.setText(userProfile.email)
        dobEt.setText(userProfile.dob)
        districtEt.setText(userProfile.dist)
        mobileEt.setText(userProfile.mobile)
    }}