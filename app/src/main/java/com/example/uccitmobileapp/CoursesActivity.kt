package com.example.uccitmobileapp


import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore

class CoursesActivity: AppCompatActivity() {

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        // Firestore collection named "Courses"
        val coursesCollection = firestore.collection("Courses")

        // Retrieve data from Firestore
        coursesCollection.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // Access the fields of the document
                    val Code = document.getString("Code")
                    val Name = document.getString("Name")
                    val Credits = document.getLong("Credits")
                    val Prerequisites = document.getString("Prerequisites")
                    val Description = document.getString("Description")

                    // Now, you can use this data to display in your UI
                    Log.d("CoursesActivity", "Course: $Code - $Name, Credits: $Credits, Prerequisites: $Prerequisites, Description: $Description")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("CoursesActivity", "Error getting documents.", exception)
            }
    }
}