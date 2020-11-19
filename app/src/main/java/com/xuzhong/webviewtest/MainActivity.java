package com.xuzhong.webviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //申请权限
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
            //申请权限
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                    Manifest.permission.INTERNET},1);
        }else {

            WebView webView = (WebView) findViewById(R.id.web_view);
            //调用了setJavaScriptEnabled()方法来让WebView支持JavaScript脚本
            webView.getSettings().setJavaScriptEnabled(true);
            //当需要从一个网页跳转到另一个网页时，我们希望目标网页仍然在当前WebView中显示，而不是打开系统浏览器
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://www.baidu.com");
        }
    }
}