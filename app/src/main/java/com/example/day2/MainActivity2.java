package com.example.day2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity2 extends Activity {
	public Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		
		button1 = (Button) MainActivity2.this.findViewById(R.id.button1);
		button2 = (Button) MainActivity2.this.findViewById(R.id.button2);
		button3 = (Button) MainActivity2.this.findViewById(R.id.button9);
		button4 = (Button) MainActivity2.this.findViewById(R.id.button18);
		button5 = (Button) MainActivity2.this.findViewById(R.id.button23);
		button6 = (Button) MainActivity2.this.findViewById(R.id.button24);
		button7 = (Button) MainActivity2.this.findViewById(R.id.button25);
		button8 = (Button) MainActivity2.this.findViewById(R.id.button26);
		button9 = (Button) MainActivity2.this.findViewById(R.id.button27);
		button10 = (Button) MainActivity2.this.findViewById(R.id.button29);
		button11 = (Button) MainActivity2.this.findViewById(R.id.button30);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity2.this,MainActivity.class);
				MainActivity2.this.startActivity(intent);
				
			}
		});
		
         button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity2.this,ComplexwidgetActivity.class);
				MainActivity2.this.startActivity(intent);
				
			}
		});
         
         button3.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				Intent intent = new Intent(MainActivity2.this,ActivityTest1Activity.class);
 				MainActivity2.this.startActivity(intent);
 				
 			}
 		});
         
         button4.setOnClickListener(new OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				Intent intent = new Intent(MainActivity2.this,ServiceActivity.class);
  				MainActivity2.this.startActivity(intent);
  				
  			}
  		});
         
         button5.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO Auto-generated method stub
   				Intent intent = new Intent(MainActivity2.this,BroadCastActivity.class);
   				MainActivity2.this.startActivity(intent);
   				
   			}
   		});
         
         button6.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// TODO Auto-generated method stub
    				Intent intent = new Intent(MainActivity2.this,SaveActivity.class);
    				MainActivity2.this.startActivity(intent);
    				
    			}
    		});
         
         button7.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				Intent intent = new Intent(MainActivity2.this,HandlerTestActivity.class);
 				MainActivity2.this.startActivity(intent);
 				
 			}
 		});
         
         button8.setOnClickListener(new OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				Intent intent = new Intent(MainActivity2.this,WebViewActivity.class);
  				MainActivity2.this.startActivity(intent);
  				
  			}
  		});
         
         button9.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO Auto-generated method stub
   				Intent intent = new Intent(MainActivity2.this,NetActivity.class);
   				MainActivity2.this.startActivity(intent);
   				
   			}
   		});
         
         button10.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// TODO Auto-generated method stub
    				Intent intent = new Intent(MainActivity2.this,ParseActivity.class);
    				MainActivity2.this.startActivity(intent);
    				
    			}
    		});
         
         button11.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				Intent intent = new Intent(MainActivity2.this,MapActivity.class);
 				MainActivity2.this.startActivity(intent);
 				
 			}
 		});
		
	}

	

}
