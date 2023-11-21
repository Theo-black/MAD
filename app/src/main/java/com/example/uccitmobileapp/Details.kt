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
        val name: TextView = findViewById(R.id.NAME)
        val email: TextView = findViewById(R.id.EMAIL)
        val phone: TextView = findViewById(R.id.PHONE)
        val photo: ImageView = findViewById(R.id.PHOTO)

        //Assigns value to elements according to retrieved index
        when(index){
            "0" -> {
                name.text = "HENRY, OSBOURNE"
                email.text = "hosbourne@ucc.edu.jm"
                phone.text = "18769063000"
                photo.setImageResource(R.drawable.henry)
            }
            "1" -> {
                name.text = "NATALIE, ROSE"
                email.text = "ithod@ucc.edu.jm"
                phone.text = "18768382408"
                photo.setImageResource(R.drawable.rose)
            }
            "2" -> {
                name.text = "OTIS, OSBOURNE"
                email.text = "itfaculty@ucc.edu.jm"
                phone.text = "18762182935"
                photo.setImageResource(R.drawable.otis)
            }
            "3" -> {
                name.text = "SAJJAD, RIZVI"
                email.text = "itfaculty@ucc.edu.jm"
                phone.text = "933102266566"
                photo.setImageResource(R.drawable.rizvi)
            }
            "4" -> {
                name.text = "CECIL, WHITE"
                email.text = "cwhite01@faculty.ucc.edu.jm"
                phone.text = "18764283911"
                photo.setImageResource(R.drawable.id)
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