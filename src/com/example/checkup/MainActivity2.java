package com.example.checkup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends Activity {
	
	Spinner p,h,pr;
	Button r;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		
		
		p=(Spinner) findViewById(R.id.spinner1);
		String item[]={"Chennai"};
		ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
		p.setAdapter(a);
		pr=(Spinner) findViewById(R.id.spinner3);
		String item1[]={"stomach pain","fever","cough","vomitting","head ache","other"};
		ArrayAdapter<String> b=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item1);
		pr.setAdapter(b);
		h=(Spinner) findViewById(R.id.spinner2);
		String item2[]={"SPR HOSPITAL"};
		ArrayAdapter<String> c=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item2);
		h.setAdapter(c);
		r=(Button) findViewById(R.id.button1);
		r.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i=new Intent(MainActivity2.this,MainActivity3.class);	
			startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity2, menu);
		return true;
	}

}
