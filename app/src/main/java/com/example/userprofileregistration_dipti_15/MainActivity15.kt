package com.example.userprofileregistration_dipti_15

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity15 : AppCompatActivity() {
    private lateinit var listbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main15)


        listbtn= findViewById(R.id.btn)

        val txt= findViewById<TextView>(R.id.welcometxt)
        val p= txt.paint
        val width=p.measureText(txt.text.toString())


        listbtn.setOnClickListener{
            startActivity(Intent(this, ProfileList3Activity15::class.java))
            finish()
        }



    }
}