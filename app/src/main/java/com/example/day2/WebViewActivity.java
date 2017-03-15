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
		requestWindowFeature(Window.FEATURE_NO_TITLE);//���ñ���Ϊ��
		setContentView(R.layout.activity_web_view);

		webView = (WebView) WebViewActivity.this.findViewById(R.id.webview);
		progressBar = (ProgressBar) WebViewActivity.this
				.findViewById(R.id.progressbar);
		webView.getSettings().setJavaScriptEnabled(true);// ����֧��java�ű�   ���������������
		
		webView.loadUrl("http://www.sina.com/");// ������ַ
		
		webView.setWebViewClient(new WebViewClient() {
			@Override
			//��������Ҫ��һ����ҳ������һ����ҳʱ������ϣ��Ŀ����ҳ��Ȼ�ڵ�ǰWebView����ʾ�������Ǵ�ϵͳ�����
			public boolean shouldOverrideUrlLoading(WebView view, String url) {//
				// TODO Auto-generated method stub
				view.loadUrl(url);//���ݴ���Ĳ�����ȥ�����µ���ҳ
				return true;//��ʾ��ǰwebView���Դ��������ҳ�����󣬲��ý���ϵͳ�����
			}
		});
		webView.setWebChromeClient(new WebChromeClient() {//���ý�����
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
	public boolean onKeyDown(int keyCode, KeyEvent event) {// ���÷���ʱ ��Ϊ��һ��ҳ��
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
