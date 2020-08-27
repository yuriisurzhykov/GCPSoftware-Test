package com.yuriysurzhikov.gcpsoftwaretest.ui.url

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.ActionMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.yuriysurzhikov.gcpsoftwaretest.R
import kotlinx.android.synthetic.main.fragment_webview.*
import okhttp3.internal.cache.CacheStrategy

class UrlFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("param")?.let { bindParam(it) }
    }

    private fun bindParam(param: String) {
        web_view.settings.javaScriptEnabled = true
        web_view.webViewClient = CustomWebView(progress_bar)
        web_view.loadUrl(param)
    }
}

class CustomWebView(private val progressBar: ProgressBar): WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        progressBar.visibility = View.VISIBLE
    }
}