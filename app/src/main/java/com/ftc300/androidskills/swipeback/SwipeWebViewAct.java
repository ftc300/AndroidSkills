package com.ftc300.androidskills.swipeback;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.ftc300.androidskills.R;
import com.ftc300.androidskills.swipeback.lib.SwipeBackActivity;
import com.ftc300.androidskills.swipeback.lib.SwipeBackLayout;

/**
 * Created by Eric on 15/6/1.
 */
public class SwipeWebViewAct extends SwipeBackActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_swipe_webview);
        setDragEdge(SwipeBackLayout.DragEdge.TOP);
        initViews();
    }

    private void initViews() {
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://github.com");
    }

}
