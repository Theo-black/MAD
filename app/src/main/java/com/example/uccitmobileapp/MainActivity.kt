package com.example.uccitmobileapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val mail: String = "ucconline@ucc.edu.jm"
    private val url: String = "https://ucc.edu.jm/apply/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Click listeners for  buttons
        var facultyStaffBtn: Button = findViewById(R.id.facultyStaffBtn)
        facultyStaffBtn.setOnClickListener {
            var intent = Intent(this, FacultyStaffActivity::class.java)
            startActivity(intent)
        }

        var coursesBtn: Button = findViewById(R.id.coursesBtn)
        coursesBtn.setOnClickListener {
            var intent = Intent(this, CoursesActivity::class.java)
            startActivity(intent)
        }

        var admissionsBtn: Button = findViewById(R.id.admissionsBtn)
        admissionsBtn.setOnClickListener {
            var intent = Intent(this, AdmissionsActivity::class.java)
            startActivity(intent)
        }
        var socialMediaBtn: Button = findViewById(R.id.socialMediaBtn)
        socialMediaBtn.setOnClickListener {
            var intent = Intent(this, SocialMediaActivity::class.java)
            startActivity(intent)
        }
        //Launches device browser and loads specified URL
        val admissions: Button = findViewById(R.id.admissionsBtn)
        admissions.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }

        // Click listener for Email FAB button
        val emailBtn: FloatingActionButton = findViewById(R.id.emailBtn)
        emailBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, mail)
            startActivity(intent)
        }
    }
}