package com.example.day2;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends Activity {
	private WebView webView;
	ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//设置标题为空
		setContentView(R.layout.activity_web_view);

		webView = (WebView) WebViewActivity.this.findViewById(R.id.webview);
		progressBar = (ProgressBar) WebViewActivity.this
				.findViewById(R.id.progressbar);
		webView.getSettings().setJavaScriptEnabled(true);// 设置支持java脚本   设置浏览器的属性
		
		webView.loadUrl("http://www.sina.com/");// 设置网址
		
		webView.setWebViewClient(new WebViewClient() {
			@Override
			//表明当需要从一个网页跳到另一个网页时，我们希望目标网页仍然在当前WebView中显示，而不是打开系统浏览器
			public boolean shouldOverrideUrlLoading(WebView view, String url) {//
				// TODO Auto-generated method stub
				view.loadUrl(url);//根据传入的参数再去加载新的网页
				return true;//表示当前webView可以处理打开新网页的请求，不用借助系统浏览器
			}
		});
		webView.setWebChromeClient(new WebChromeClient() {//设置进度条
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				progressBar.setProgress(newProgress);
				if (newProgress == 100 || newProgress == 0) {
					progressBar.setVisibility(View.INVISIBLE);
				} else {
					progressBar.setVisibility(View.VISIBLE);
				}

			}

		});

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {// 设置返回时 ，为上一级页面
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();
			} else {
				WebViewActivity.this.finish();
			}
		}
		return true;
	}

}
