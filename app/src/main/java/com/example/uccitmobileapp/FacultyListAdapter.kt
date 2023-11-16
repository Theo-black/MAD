package com.example.uccitmobileapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_faculty.view.*

class FacultyListAdapter(context: Context, private val facultyList: List<Faculty>) :
    ArrayAdapter<Faculty>(context, 0, facultyList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_faculty, parent, false)
        }

        val faculty = getItem(position)

        // Populate the UI elements with faculty data
        view?.facultyName?.text = faculty?.name
        // Populate other UI elements
        // ...

        return view!!
    }
}
