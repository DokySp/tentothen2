package space.doky.tentothen2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.DownloadListener
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import space.doky.tentothen2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val baseUrl: String = "https://tentothen2.imweb.me/"
    private lateinit var binding: ActivityMainBinding
    private lateinit var webview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webview = binding.webView

        webview.setBackgroundColor(Color.TRANSPARENT)
        webview.webViewClient = WebViewClient()
        webview.webChromeClient = WebChromeClient()

        webview.settings.loadWithOverviewMode = true
        webview.settings.useWideViewPort = true
        webview.settings.setSupportZoom(false)
        webview.settings.builtInZoomControls = false
        webview.settings.javaScriptEnabled = true
        webview.settings.javaScriptCanOpenWindowsAutomatically = true
        webview.settings.setSupportMultipleWindows(false)
        webview.settings.domStorageEnabled = true

        webview.loadUrl(baseUrl)
    }

    override fun onBackPressed() {
        if(webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}