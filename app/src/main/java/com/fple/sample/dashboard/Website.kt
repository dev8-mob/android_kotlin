package com.fple.sample.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.fple.sample.R

class Website : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var root = inflater.inflate(R.layout.fragment_website, container, false)
        val webview = root.findViewById<WebView>(R.id.webview)

        webview.getSettings().setJavaScriptEnabled(true);
        val webSettings: WebSettings = webview.getSettings()
        webSettings.javaScriptEnabled = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.domStorageEnabled = true

        webview.setWebViewClient(WebViewController())
        webview.loadUrl("http://www.applab.com.my/")
        return root
    }

    internal class WebViewController : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}