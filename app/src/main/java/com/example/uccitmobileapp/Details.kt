package com.example.uccitmobileapp
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //Gets value sent from Directory activity
        val index: String? = this.intent.getStringExtra("listIndex")

        //Creates objects for each activity element
        val name: TextView = findViewById(R.id.tvName)
        val email: TextView = findViewById(R.id.tvEmail)
        val photo: ImageView = findViewById(R.id.ivProfile)

        //Assigns value to elements according to retrieved index
        when(index){
            "0" -> {
                name.text = "HENRY, OSBOURNE"
                email.text = "hosbourne@ucc.edu.jm"
                photo.setImageResource(R.drawable.henry)
            }
            "1" -> {
                name.text = "NATALIE, ROSE"
                email.text = "ithod@ucc.edu.jm"
                photo.setImageResource(R.drawable.rose)
            }
            "2" -> {
                name.text = "OTIS, OSBOURNE"
                email.text = "itfaculty@ucc.edu.jm"
                photo.setImageResource(R.drawable.otis)
            }
            "3" -> {
                name.text = "CECIL, WHITE"
                email.text = "cwhite01@faculty.ucc.edu.jm"
                photo.setImageResource(R.drawable.white)
            }
            "4" -> {
                name.text = "NEIL, WILLIAMS"
                email.text = "itlecturer@ucc.edu.jm"
                photo.setImageResource(R.drawable.ucc_logo)
            }
        }

        //Launches email client when email address is tapped
        email.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email.toString(), null))
            intent.putExtra(Intent.EXTRA_EMAIL, email.toString())
            startActivity(intent)
        }
    }
}