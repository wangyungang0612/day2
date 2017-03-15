package com.example.day2;







import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	public TextView textView;
	public Button button,button00;
	public EditText editText;
	public RadioGroup radioGroup;
	public CheckBox checkBoxR, checkBoxL;
	public ProgressBar progressbar;
	public ImageView imageview;
	public SeekBar seekbar;
	public RatingBar ratingBar;
	private TimePicker timePick1;
	private Button button0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView) MainActivity.this
				.findViewById(R.id.myfirsttextview);

		progressbar = (ProgressBar) MainActivity.this
				.findViewById(R.id.mysecondprogressbar);

		seekbar = (SeekBar) MainActivity.this.findViewById(R.id.myfristseekbar);
		imageview = (ImageView) MainActivity.this
				.findViewById(R.id.myfristImageView);

		ratingBar = (RatingBar) MainActivity.this
				.findViewById(R.id.myfristratingbar);
		textView.setText("QQ");

		button = (Button) MainActivity.this.findViewById(R.id.myfirstbutton);
		editText = (EditText) MainActivity.this
				.findViewById(R.id.myfirstedittext1);
		button00 = (Button) MainActivity.this.findViewById(R.id.myfirstbutton00);
		/**************获取时间*******************/
		
		timePick1 = (TimePicker) MainActivity.this
				.findViewById(R.id.timePicker1);
		button0 = (Button) MainActivity.this.findViewById(R.id.buttoneee);
		timePick1.setIs24HourView(true);
		
		timePick1.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "h:" + arg1 + " m:" + arg2,
						Toast.LENGTH_SHORT).show();
				
			}
		});
		
		button0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int h = timePick1.getCurrentHour();
				int m = timePick1.getCurrentMinute();

				Toast.makeText(MainActivity.this, "h:" + h + "   m:" + m,
						Toast.LENGTH_SHORT).show();
				
			}
		});
		
      /**************************************************************/
		// 按钮点击响应
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 点击之后的响应行为写在这里
				String string = editText.getText().toString();
				textView.setText(string);

				progressbar.setProgress((progressbar.getProgress() + 5) % 100);
				

			}
		});

		// button.setOnClickListener(new MyListener());
		radioGroup = (RadioGroup) MainActivity.this
				.findViewById(R.id.myfirstradiogroup);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int postion) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,
						radioGroup.findViewById(postion).getTag().toString(),
						Toast.LENGTH_SHORT).show();
			}
		});

		checkBoxR = (CheckBox) MainActivity.this
				.findViewById(R.id.myfirstcheckbox);
		checkBoxL = (CheckBox) MainActivity.this
				.findViewById(R.id.mysecondcheckbox);

		checkBoxR
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						// TODO Auto-generated method stub
						if (arg1 == false && checkBoxL.isChecked() == true) {
							checkBoxL.setChecked(false);
						}

					}
				});

		checkBoxL
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						// TODO Auto-generated method stub
						if (arg1 == true && checkBoxR.isChecked() == false) {
							checkBoxR.setChecked(true);
						}

					}
				});

		seekbar.setMax(3600);
		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				imageview.setRotation(arg1);

			}
		});

		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, arg1 + "", Toast.LENGTH_SHORT)
						.show();

			}
		});
/*******************************************************/
		button00.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				MainActivity.this.finish();
				
			}
		});
	}

	/*
	 * class MyListener implements OnClickListener{
	 * 
	 * @Override public void onClick(View arg0) { // TODO Auto-generated method
	 * stub String string = editText.getText().toString();
	 * textView.setText(string);
	 * 
	 * 
	 * }
	 * 
	 * }
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
