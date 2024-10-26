package com.example.userprofileregistration_dipti_15


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration_dipti_15.model15.UP15
import com.example.userprofileregistration_dipti_15.viewmodel15.VM15

class ProfileListActivity15 : AppCompatActivity() {
    private lateinit var profileViewModel: VM15
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_profile15)

        profileViewModel = ViewModelProvider(this).get(VM15::class.java)

        val nameEditText = findViewById<EditText>(R.id.net)
        val emailEditText = findViewById<EditText>(R.id.eet)
        val dobEditText = findViewById<EditText>(R.id.det)
        val districtEditText = findViewById<EditText>(R.id.diet)
        val mobileEditText = findViewById<EditText>(R.id.met)

        findViewById<Button>(R.id.addbtn).setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val dob = dobEditText.text.toString()
            val district = districtEditText.text.toString()
            val mobile = mobileEditText.text.toString()

            val userProfile = UP15(name = name, email = email, dob = dob, dist = district, mobile = mobile)
            profileViewModel.insertUserProfile(userProfile)

            finish()
        }
    }
}