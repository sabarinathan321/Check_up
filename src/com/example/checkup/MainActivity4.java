package com.example.checkup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends Activity {
	EditText m;
	Button c;
	TextView display;
	SQLiteDatabase sql;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity4);
		m = (EditText) findViewById(R.id.editText1);
		c = (Button) findViewById(R.id.button1);
		display = (TextView) findViewById(R.id.textView2);
		Bundle b = getIntent().getExtras();
		String s2 = b.getString("one");
		display.setText(s2);
		sql=openOrCreateDatabase("details1", MODE_PRIVATE, null);
		sql.execSQL("create table if not exists student(n text,m text,e text,p text,cp text,pa text,a text);");


		c.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Cursor c=sql.rawQuery("select * from student1",null);
				if(c!=null)
				{
					if(c.moveToFirst())
					{
						do
						{
							String valueofcol6=c.getString(0);
							String patient=valueofcol6;
							Bundle b = getIntent().getExtras();
							String hel=b.getString("hello");
							String s2 = b.getString("one");
							SmsManager manager1=SmsManager.getDefault();
							manager1.sendTextMessage("9655062728", null, "Patient Name\n"+patient+"\nToken Number\n"+hel+s2,null,null);	
							
						}
						while(c.moveToNext());
					}
				}
				String s3 = "\nADDRESS:SPR Hospital,CHENNAI 66";
				String s4 = "\nROOM NO:21";
				Bundle b = getIntent().getExtras();
				String s2 = b.getString("one");
				String hel=b.getString("hello");
				String two=b.getString("two");
				String s1 = m.getText().toString();
				
					
					SmsManager manager = SmsManager.getDefault();
					manager.sendTextMessage(s1, null,"\nYOUR TOKEN NUMBER IS:\n"+hel + s2 +two+ s3+ "\nGET WELL SOON", null, null);

					Intent i = new Intent(MainActivity4.this,
							MainActivity5.class);
					startActivity(i);
					Toast.makeText(getApplicationContext(), "Token is sent",
							Toast.LENGTH_LONG).show();

				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity4, menu);
		return true;
	}

}
