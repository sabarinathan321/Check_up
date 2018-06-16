package com.example.checkup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class Date extends Activity {
	DatePicker picker;
	
	Button displaydate,n,displaytime;
	TextView textview1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date);
		
		picker=(DatePicker) findViewById(R.id.datePicker1);
		displaydate=(Button) findViewById(R.id.button1);
		
		textview1=(TextView) findViewById(R.id.textView1);
		n=(Button) findViewById(R.id.button2);
		displaydate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				StringBuilder builder=new StringBuilder();
				builder.append("Current Date: ");
				
				builder.append((picker.getMonth() + 1)+"/");
				
				builder.append(picker.getDayOfMonth()+"/");
				
				builder.append(picker.getYear());
				
				textview1.setText(builder);
				
			}
		});
		
		n.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Date.this,MainActivity2.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_date, menu);
		return true;
	}

}
