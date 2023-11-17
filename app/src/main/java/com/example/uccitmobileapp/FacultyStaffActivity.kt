package com.example.uccitmobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter

class FacultyStaffActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_staff)

        val staffList: Array<String> = resources.getStringArray(R.array.Staff)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, staffList)

        val listView: ListView = findViewById(R.id.lvStaff)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Clicked item : " + position, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Details::class.java);
            intent.putExtra("listIndex", position.toString());

            this.startActivity(intent);
        }
    }


}

