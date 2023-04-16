package com.ameypandit.itconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LecturesActivity extends AppCompatActivity {

    private WebView lecWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lecWebView=findViewById(R.id.lecturesWebView);
//        lecWebView.setWebViewClient(new WebViewClient());
//        WebSettings webSettings = lecWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        lecWebView.getSettings().setLoadWithOverviewMode(true);
//        lecWebView.getSettings().setUseWideViewPort(true);
//        lecWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        lecWebView.loadUrl("https://lectures.ammy.workers.dev/");

        lecWebView.setWebChromeClient(new WebChromeClient());
        lecWebView.setWebViewClient(new WebViewClient());
        lecWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        lecWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        lecWebView.clearCache(true);
        lecWebView.clearHistory();
        lecWebView.getSettings().setAllowContentAccess(true);
        lecWebView.getSettings().setDomStorageEnabled(true);
        lecWebView.getSettings().setJavaScriptEnabled(true); // enable javascript
        lecWebView.getSettings().setBuiltInZoomControls(true);
        lecWebView.getSettings().setSupportZoom(true);
        lecWebView.getSettings().setLoadWithOverviewMode(true);
        lecWebView.getSettings().setUseWideViewPort(true);

        lecWebView.getSettings().setBuiltInZoomControls(true);
        lecWebView.getSettings().setDisplayZoomControls(false);

        lecWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        lecWebView.setScrollbarFadingEnabled(false);
        lecWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        lecWebView.loadUrl("https://lectures.ammy.workers.dev/");

    }

    @Override
    public void onBackPressed() {
        if(lecWebView.canGoBack()){
            lecWebView.goBack();
        }else {
            super.onBackPressed();
        }

    }
}