package eu.glyphe.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);


        this.wv = (WebView)this.findViewById(R.id.webView);
        this.wv.getSettings().setJavaScriptEnabled(true);
        this.wv.setWebViewClient(new WebViewClient());

        String url ="http://fr.m.wikipedia.org/wiki/Roger_Federer";

        this.wv.loadUrl(url);
    }
}
