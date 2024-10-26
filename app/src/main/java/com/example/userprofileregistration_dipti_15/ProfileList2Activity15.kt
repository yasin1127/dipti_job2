package com.example.userprofileregistration_dipti_15


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.userprofileregistration_dipti_15.model15.UP15

class ProfileList2Activity15 : AppCompatActivity() {
    private lateinit var userProfile:UP15

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var dobTextView: TextView
    private lateinit var districtTextView: TextView
    private lateinit var mobileTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_list215)
        userProfile = intent.getSerializableExtra("USER_PROFILE") as UP15

        nameTextView = findViewById(R.id.ntxt)
        emailTextView = findViewById(R.id.etxt)
        dobTextView = findViewById(R.id.bodtxt)
        districtTextView = findViewById(R.id.Dtxt)
        mobileTextView = findViewById(R.id.mtxt)

        populateFields()
    }

    private fun populateFields() {
        nameTextView.text = userProfile.name
        emailTextView.text = userProfile.email
        dobTextView.text = userProfile.dob
        districtTextView.text = userProfile.dist
        mobileTextView.text = userProfile.mobile
    }
}