package com.example.uccitmobileapp

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class SocialMediaActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_socialmedia)

        val web: WebView = findViewById(R.id.wvSocialMedia)
        web.webViewClient = CustomWebViewClient(this)
        web.loadUrl("https://www.instagram.com/uccjamaica/")

        val webSettings = web.settings
        webSettings.javaScriptEnabled = true
    }
}