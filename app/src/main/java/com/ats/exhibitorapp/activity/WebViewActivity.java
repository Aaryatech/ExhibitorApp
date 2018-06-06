package com.ats.exhibitorapp.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ats.exhibitorapp.R;
public class WebViewActivity extends AppCompatActivity {

    private String postUrl = "https://www.google.com";
    private WebView wvPortfolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wvPortfolio = (WebView) findViewById(R.id.wvPortfolio);

        WebSettings webSettings = wvPortfolio.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");
wvPortfolio.setWebViewClient(new WebViewClient());

        wvPortfolio.loadUrl(postUrl);
        wvPortfolio.setHorizontalScrollBarEnabled(false);




    }
}
