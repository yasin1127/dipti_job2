package com.example.userprofileregistration_dipti_15

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration_dipti_15.adapter15.ProfileAdapter15
import com.example.userprofileregistration_dipti_15.viewmodel15.VM15


import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileList3Activity15 : AppCompatActivity() {

    private lateinit var profileViewModel: VM15
    private lateinit var profileAdapter: ProfileAdapter15

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_list315)

        profileViewModel = ViewModelProvider(this).get(VM15::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.RV)
        profileAdapter = ProfileAdapter15()

        recyclerView.adapter = profileAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        profileViewModel.getUserProfiles().observe(this, Observer { profiles ->
            profileAdapter.submitList(profiles)
        })

        profileAdapter.setOnItemClickListener { userProfile ->
            val intent = Intent(this@ProfileList3Activity15, SingleProfileActivity15::class.java)
            intent.putExtra("USER_PROFILE", userProfile)
            startActivity(intent)
        }

        profileAdapter.setOnDeleteClickListener { userProfile ->
            profileViewModel.deletetUserProfile(userProfile)
        }


        profileAdapter.setOnUpdateClickListener { userProfile ->
            val intent = Intent(this@ProfileList3Activity15, UpdateProfileActivity15::class.java)
            intent.putExtra("USER_PROFILE", userProfile)
            startActivity(intent)
        }

        findViewById<FloatingActionButton>(R.id.addbtn).setOnClickListener {
            val intent = Intent(this@ProfileList3Activity15, AddProfileActivity15::class.java)
            startActivity(intent)
        }
    }
}