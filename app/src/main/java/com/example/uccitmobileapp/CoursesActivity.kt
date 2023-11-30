package com.example.uccitmobileapp


import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class CoursesActivity : AppCompatActivity() {

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courserecyclerview)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Firestore collection named "Courses"
        val coursesCollection = firestore.collection("Courses")

        // Retrieve data from Firestore
        coursesCollection.get()
            .addOnSuccessListener { result ->
                val coursesList = mutableListOf<CourseDetails>()

                for (document in result) {
                    // Access the fields of the document
                    val code = document.getString("Code")
                    val name = document.getString("Name")
                    val credits = document.getLong("Credits")?.toString()
                    val prerequisite = document.getString("Prerequisite")
                    val description = document.getString("Description")

                    // Add the course to the list
                    coursesList.add(CourseDetails(code, name, credits, prerequisite, description))

                    // Now, you can use this data to display in your UI
                    Log.d(
                        "CoursesActivity",
                        "Course: $code - $name, Credits: $credits, Prerequisite: $prerequisite, Description: $description"
                    )
                }

                // Set up the RecyclerView with the custom adapter
                val adapter = CoursesAdapter(coursesList)
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Log.w("CoursesActivity", "Error getting documents.", exception)
            }
    }
}