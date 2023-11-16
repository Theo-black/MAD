package com.example.uccitmobileapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Click listeners for  buttons
        var facultyStaffBtn: Button = findViewById(R.id.FacultyStaffBtn)
        facultyStaffBtn.setOnClickListener {
            var intent = Intent(this, FacultyStaffActivity::class.java)
            startActivity(intent)
        }

        var coursesBtn: Button = findViewById(R.id.FacultyStaffBtn)
        FacultyStaffBtn.setOnClickListener {
            var intent = Intent(this, FacultyStaffActivity::class.java)
            startActivity(intent)
        }

        var FacultyStaffBtn: Button = findViewById(R.id.FacultyStaffBtn)
        FacultyStaffBtn.setOnClickListener {
            var intent = Intent(this, FacultyStaffActivity::class.java)
            startActivity(intent)
        }
        var FacultyStaffBtn: Button = findViewById(R.id.FacultyStaffBtn)
        FacultyStaffBtn.setOnClickListener {
            var intent = Intent(this, FacultyStaffActivity::class.java)
            startActivity(intent)
        }
        // Click listener for Email FAB button
        emailFab.setOnClickListener {

        }
    }
}