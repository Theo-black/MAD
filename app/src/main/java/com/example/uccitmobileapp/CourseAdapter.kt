package com.example.uccitmobileapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter(private val coursesList: List<CourseDetails>) :
    RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCode: TextView = itemView.findViewById(R.id.textCode)
        val textName: TextView = itemView.findViewById(R.id.textName)
        val textCredits: TextView = itemView.findViewById(R.id.textCredits)
        val textPrerequisite: TextView = itemView.findViewById(R.id.textPrerequisite)
        val textDescription: TextView = itemView.findViewById(R.id.textDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_courses, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = coursesList[position]
        holder.textCode.text = " Code:${course.code}"
        holder.textName.text = " Name:${course.name}"
        holder.textCredits.text = "Credits: ${course.credits}"
        holder.textPrerequisite.text = "Prerequisite: ${course.prerequisite}"
        holder.textDescription.text = "Description: ${course.description}"
    }

    override fun getItemCount(): Int {
        return coursesList.size
    }
}
