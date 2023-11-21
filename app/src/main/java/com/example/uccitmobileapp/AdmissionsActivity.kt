package com.example.uccitmobileapp

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class AdmissionsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_admissions)

            val web: WebView = findViewById(R.id.wvAdmission)
            web.webViewClient = CustomWebViewClient(this)
            web.loadUrl("https://www.ucc.edu.jm/department/registry/admissions")

            val webSettings = web.settings
            webSettings.javaScriptEnabled = true
        }
    }

private fun Any.onCreate(savedInstanceState: Bundle?) {

}
