package com.example.userprofileregistration_dipti_15

import com.example.userprofileregistration_dipti_15.viewmodel15.VM15

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration_dipti_15.model15.UP15

class AddProfileActivity15 : AppCompatActivity() {
    private lateinit var profileViewModel:ViewModel

    private lateinit var nameTxt:EditText
    private lateinit var emailTxt:EditText
    private lateinit var dobTxt:EditText
    private lateinit var districtTxt:EditText
    private lateinit var mobileTxt:EditText
    private lateinit var save:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_profile15)

        profileViewModel= ViewModelProvider(this).get(VM15::class.java)

        nameTxt=findViewById(R.id.net)
        emailTxt=findViewById(R.id.eet)
        dobTxt=findViewById(R.id.det)
        districtTxt=findViewById(R.id.diet)
        mobileTxt=findViewById(R.id.met)


        save=findViewById(R.id.addbtn)

        save.setOnClickListener {
            val name=nameTxt.text.toString().trim()
            val email=emailTxt.text.toString().trim()
            val dob=dobTxt.text.toString().trim()
            val district=districtTxt.text.toString().trim()
            val mobile=mobileTxt.text.toString().trim()

            val userProfile= UP15(name = name, email = email, dob=dob, dist=district, mobile= mobile)
            (profileViewModel as VM15).insertUserProfile(userProfile)
            finish()

        }

    }
}