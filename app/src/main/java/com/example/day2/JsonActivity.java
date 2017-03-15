package com.example.day2;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.day2.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JsonActivity extends Activity implements OnClickListener {
	public Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);
		button = (Button) JsonActivity.this.findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sendRequestWithHttpClient() ;
			}
		});

	}

	private void sendRequestWithHttpClient() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					HttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(
							"http://121.41.111.208:8080/jsetc_wsdl/headlinesList.jsp");
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity entity = httpResponse.getEntity();
						String response = EntityUtils.toString(entity, "utf-8");
						parseJSONWithJSONObject(response);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	private void parseJSONWithJSONObject(String jsonData) {
		try {
			JSONObject jsonObject = new JSONObject(jsonData);
			String resultcode = jsonObject.optString("resultcode", "default");
			System.out.println("resultcode is " + resultcode);

			JSONArray jsonArray = jsonObject.optJSONArray("result");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject2 = jsonArray.optJSONObject(i);
				String url1 = jsonObject2.optString("url1", "default");
				String url2 = jsonObject2.optString("url2", "default");
				String title = jsonObject2.optString("title", "default");
				String content = jsonObject2.optString("content", "default");

				System.out.println("url1 is " + url1);
				System.out.println("url2 is " + url2);
				System.out.println("title is " + title);
				System.out.println("content is " + content);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
