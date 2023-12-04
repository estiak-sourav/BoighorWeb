package com.pealpeal.boighorweb;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * Created by Estiak on 12/4/23
 */
public class BoiGhorWeb {

    public static void getBoighorWeb(Context context, ConstraintLayout mainView){

        WebView webview = new WebView(context);
        webview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        webview.bringToFront();

        mainView.addView(webview);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());

        webview.getSettings().setDomStorageEnabled(true);
        final ProgressDialog pd = ProgressDialog.show(context, "", "Loading...", true);
        webview.getSettings().setJavaScriptEnabled(true);

        webview.loadUrl("https://boighor.com/");
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                pd.show();
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                pd.dismiss();
            }
        });
    }
}
