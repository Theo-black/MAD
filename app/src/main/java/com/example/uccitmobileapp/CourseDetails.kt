package com.example.uccitmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

data class CourseDetails(
    val code: String?,
    val name: String?,
    val credits: String?,
    val prerequisite: String?,
    val description: String?
)