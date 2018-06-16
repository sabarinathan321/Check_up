package com.example.checkup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends Activity {
	TextView d,r,pr;
	static int l=1,q=1,z=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity3);
		pr=(TextView) findViewById(R.id.textView4);
		pr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity3.this,MainActivity4.class);
				Bundle b=new Bundle();
				b.putString("one","DOCTOR NAME:Dr.PRADHEEP M.B.B.S.M.D");
				b.putString("two","\nROOM NUMBER:22");
				b.putString("hello",l+"");
				++l;
				i.putExtras(b);
				startActivity(i);
				
			}
		});
		r=(TextView) findViewById(R.id.textView3);
		r.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity3.this,MainActivity4.class);
				Bundle b=new Bundle();
				b.putString("one","\nDOCTOR NAME:Dr.RAMJI M.B.B.S.M.D");
				b.putString("two","\nROOM NUMBER:23");
			   b.putString("hello",q+"");
				++q;
				i.putExtras(b);
				startActivity(i);
				
			}
		});
		d=(TextView) findViewById(R.id.textView2);
		d.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity3.this,MainActivity4.class);
				Bundle b=new Bundle();
				b.putString("one","\nDOCTOR NAME:Dr.SABARINATHAN M.B.B.S,M.D");
				b.putString("two","\nROOM NUMBER:24");
				b.putString("hello",z+"");
				++z;
				i.putExtras(b);
				startActivity(i);
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity3, menu);
		return true;
	}

}
