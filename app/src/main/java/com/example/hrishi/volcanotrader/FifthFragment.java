package com.example.hrishi.volcanotrader;

import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FifthFragment extends Fragment{

    View myView;
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        String url = "https://in.tradingview.com/";

        myView = inflater.inflate(R.layout.fifth_layout, container, false);
        webView = myView.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(url);

        return myView;

    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        fragmentManager.beginTransaction().replace(R.id.content_frame, new FifthFragment()).commit();
//    }
}
