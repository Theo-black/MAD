package com.example.uccitmobileapp

import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class SocialMediaActivity : AppCompatActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_socialmedia)

            val web: WebView = findViewById(R.id.wvSocialMedia)
            val webSettings = web.settings
            webSettings.javaScriptEnabled = true

            val instagramButton: Button = findViewById(R.id.btnInstagram)
            val facebookButton: Button = findViewById(R.id.btnFacebook)
            val twitterButton: Button = findViewById(R.id.btnTwitter)

            instagramButton.setOnClickListener {
                loadUrlInWebView("https://www.instagram.com/uccjamaica", web)
            }

            facebookButton.setOnClickListener {
                loadUrlInWebView("https://www.facebook.com/uccjamaica/", web)
            }

            twitterButton.setOnClickListener {
                loadUrlInWebView("https://twitter.com/UCCjamaica", web)
            }
        }

        private fun loadUrlInWebView(url: String, webView: WebView) {
            webView.webViewClient = CustomWebViewClient(this)
            webView.loadUrl(url)
        }
    }

    class CustomWebViewClient internal constructor(private val activity: AppCompatActivity) :
        WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url: String = request?.url.toString()
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(
            view: WebView,
            request: WebResourceRequest,
            error: WebResourceError
        ) {
            Toast.makeText(activity, "Error loading page! $error", Toast.LENGTH_SHORT).show()
        }
    }

