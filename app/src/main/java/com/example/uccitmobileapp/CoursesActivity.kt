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

        // Assuming you have a Firestore collection named "courses"
        val coursesCollection = firestore.collection("courses")

        // Retrieve data from Firestore
        coursesCollection.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // Access the fields of the document
                    val code = document.getString("code")
                    val name = document.getString("name")
                    val credits = document.getLong("credits")
                    val prerequisites = document.getString("prerequisites")
                    val description = document.getString("description")

                    // Now, you can use this data to display in your UI
                    Log.d("CoursesActivity", "Course: $code - $name, Credits: $credits, Prerequisites: $prerequisites, Description: $description")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("CoursesActivity", "Error getting documents.", exception)
            }
    }
}