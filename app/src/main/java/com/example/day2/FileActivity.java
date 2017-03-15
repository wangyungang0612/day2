package com.example.day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.util.EncodingUtils;

import com.example.adapter.MyListAdapter;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class FileActivity extends Activity {
	private static final String ROOT = Environment
			.getExternalStorageDirectory().getPath();
	private ListView listView;
	private SimpleAdapter simpleAdapter;
	private ArrayList<HashMap<String, String>> list;
	private String currentPath = null;
	public Button button1,button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file);
		listView = (ListView) findViewById(R.id.listview_file);
		button1 = (Button) FileActivity.this.findViewById(R.id.button1);
		button2 = (Button) FileActivity.this.findViewById(R.id.button2);
		getData(ROOT);
			
		}

	private void getData(String path) {
		// 获取root目录文件
		currentPath = path;
		File file = new File(path);
		// 将root目录下所有文件保存到文件数组中
		File[] files = file.listFiles();
		list = new ArrayList<HashMap<String, String>>();

		if (!currentPath.equals(ROOT)) {
			HashMap<String, String> map1 = new HashMap<String, String>();
			HashMap<String, String> map2 = new HashMap<String, String>();

			map1.put("name", "返回 根目录");
			map1.put("path", ROOT);

			map2.put("name", "返回上一层");
			map2.put("path", file.getParent());

			list.add(map1);
			list.add(map2);
		}

		for (int i = 0; i < files.length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", files[i].getName());
			map.put("path", files[i].getPath());
			list.add(map);
		}

		simpleAdapter = new SimpleAdapter(FileActivity.this, list,
				R.layout.item_file, new String[] { "name" },
				new int[] { R.id.myfilename });
		listView.setAdapter(simpleAdapter);
		
		
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String fileName = "TEST.txt";
				String message = "FFFFFFF11111FFFFF";
				writeFileData(fileName, message);
//				Toast.makeText(FileActivity.this, "here", Toast.LENGTH_SHORT)
//						.show();
				getData(currentPath);
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String fileName = "TEST.txt";
				String message = "FFFFFFF11111FFFFF";
				fileSave(fileName, message,currentPath);
				
				getData(currentPath);
			}
		});
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				File file = new File(list.get(arg2).get("path"));
				if (file.canRead()) {
					if (file.isDirectory()) {
						getData(list.get(arg2).get("path"));
					} else {
						String end = file
								.getName()
								.substring(file.getName().lastIndexOf(".") + 1,
										file.getName().length()).toLowerCase();

						if (end.equals("jpg") || end.equals("gif")
								|| end.equals("png") || end.equals("jpeg")
								|| end.equals("bmp")) {
							Intent intent = new Intent(
									"android.intent.action.VIEW");
							intent.addCategory("android.intent.category.DEFAULT");
							intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							intent.setDataAndType(Uri.fromFile(file), "image/*");
							startActivity(intent);

						}

						else if (end.equals("3gp") || end.equals("mp4")) {
							Intent intent = new Intent(
									"android.intent.action.VIEW");
							intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							intent.putExtra("oneshot", 0);
							intent.putExtra("configchange", 0);
							intent.setDataAndType(Uri.fromFile(file), "audio/*");
							startActivity(intent);

						}

						else if (end.equals("m4a") || end.equals("mp3")
								|| end.equals("mid") || end.equals("xmf")
								|| end.equals("ogg") || end.equals("wav")) {
							Intent intent = new Intent(
									"android.intent.action.VIEW");
							intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							intent.putExtra("oneshot", 0);
							intent.putExtra("configchange", 0);
							intent.setDataAndType(Uri.fromFile(file), "audio/*");
							startActivity(intent);

						}

						// Intent("android.intent.action.VIEW");
						// intent.addCategory("android.intent.category.DEFAULT");
						// intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						//
						// intent.setDataAndType(Uri.fromFile(file), "image/*");
						// startActivity(intent);

						// Toast.makeText(FileActivity.this,
						// list.get(arg2).get("name") + "是普通文件",
						// Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(FileActivity.this, "权限不足",
							Toast.LENGTH_SHORT).show();
				}
				// getData(list.get(arg2).get("path"));

			}
		});
	}
	
	
	public void writeFileData(String fileName,String message){ 

	       try{ 

	        FileOutputStream fout =openFileOutput(fileName, MODE_PRIVATE);

	        byte [] bytes = message.getBytes(); 

	        fout.write(bytes); 

	         fout.close(); 

	        } 

	       catch(Exception e){ 

	        e.printStackTrace(); 

	       } 

	   }    
	
	public String readFileData(String fileName){ 

     String res=""; 

     try{ 

      FileInputStream fin = openFileInput(fileName); 

      int length = fin.available(); 

      byte [] buffer = new byte[length]; 

      fin.read(buffer);     

      res = EncodingUtils.getString(buffer, "UTF-8"); 

      fin.close();     

     } 

     catch(Exception e){ 

      e.printStackTrace(); 

     } 

     return res; 

 }   
	
	public void writeFileSdcard(String fileName,String message){ 

	       try{ 

	        //FileOutputStream fout = openFileOutput(fileName, MODE_PRIVATE);

	       FileOutputStream fout = new FileOutputStream(fileName);

	        byte [] bytes = message.getBytes(); 

	        fout.write(bytes); 

	         fout.close(); 

	        } 

	       catch(Exception e){ 

	        e.printStackTrace(); 

	       } 

	   }
	
	public static boolean fileSave(String fileName, String fileContent,String path ) { 
     File file = new File(path, fileName); 
     if (!file.exists()) { 
         try { 
             file.createNewFile(); 
         } catch (IOException e) { 
             e.printStackTrace(); 
         } 
     } 
     FileOutputStream fos = null; 
     int count = 0; 
     try { 
         fos = new FileOutputStream(file); 
         count = fileContent.getBytes().length; 
         fos.write(fileContent.getBytes(), 0, count); 
         fos.close(); 
         return true; 
     } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
     } catch (UnsupportedEncodingException e) { 
         e.printStackTrace(); 
     } catch (IOException e) { 
         e.printStackTrace(); 
     } 
     return false; 
 } 

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			System.out.println(currentPath);
			if (!currentPath.equals(ROOT)) {
				getData(new File(currentPath).getParent());
			} else {
				FileActivity.this.finish();
			}
		}
		return true;
	}

}
