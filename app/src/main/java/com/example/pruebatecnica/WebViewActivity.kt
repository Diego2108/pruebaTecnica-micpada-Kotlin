package com.example.pruebatecnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.pruebatecnica.databinding.ActivityWebViewBinding

private lateinit var binding: ActivityWebViewBinding
class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        webViewSetup()
    }

    private fun webViewSetup() {
        val mWebView = binding.webViewMicpadaPrueba
        mWebView.webViewClient = WebViewClient()

        mWebView.apply {
            loadUrl("https://www.micpada.com")
            settings.javaScriptEnabled = true
        }
    }
}