package com.example.userprofileregistration_dipti_15

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration_dipti_15.model15.UP15
import com.example.userprofileregistration_dipti_15.viewmodel15.VM15


class SingleProfileActivity15 : AppCompatActivity() {
    private lateinit var userProfile: UP15
    private lateinit var nameTxt:TextView
    private lateinit var emailTxt:TextView
    private lateinit var dobTxt:TextView
    private lateinit var districtTxt:TextView
    private lateinit var mobileTxt:TextView
    private lateinit var updateBtn:ImageButton
    private lateinit var deleteBtn:ImageButton

    private lateinit var profileViewModel: VM15


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_profile15)

        profileViewModel=ViewModelProvider(this).get(VM15::class.java)

        userProfile= intent.getSerializableExtra("User_Profile") as UP15

        nameTxt=findViewById(R.id.name)
        emailTxt=findViewById(R.id.email)
        dobTxt=findViewById(R.id.dob)
        districtTxt=findViewById(R.id.dis)
        mobileTxt=findViewById(R.id.mob)
        updateBtn=findViewById(R.id.ebtn)
        deleteBtn=findViewById(R.id.dbtn)

        updateBtn.setOnClickListener {
            val intent= (Intent(this,UpdateProfileActivity15::class.java).apply {
                putExtra("User_Profile",userProfile)
                startActivity(intent)
            })
        }

        deleteBtn.setOnClickListener {
            profileViewModel.deletetUserProfile(userProfile)
            finish()
        }
        populatedFields()

    }

    private fun populatedFields() {
        nameTxt.text=userProfile.name
        emailTxt.text=userProfile.email
        dobTxt.text=userProfile.dob
        districtTxt.text=userProfile.dist
        mobileTxt.text=userProfile.mobile
    }
}
