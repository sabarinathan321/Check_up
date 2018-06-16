package com.example.checkup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity1 extends Activity {
	EditText p, ag;
	Button n;
	Spinner spin;
	SQLiteDatabase sql1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);
		p = (EditText) findViewById(R.id.editText1);
		ag = (EditText) findViewById(R.id.editText2);
		n = (Button) findViewById(R.id.button1);
		spin = (Spinner) findViewById(R.id.spinner1);
		String item[] = { "MALE", "FEMALE" };
		ArrayAdapter<String> a = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, item);
		spin.setAdapter(a);
		sql1 = openOrCreateDatabase("details1", MODE_PRIVATE, null);
		sql1.execSQL("create table if not exists student1(p text,ag text);");
		n.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String gPatient = p.getText().toString();
				String gAge = ag.getText().toString();
				if ((gPatient.length() > 0) & (gAge.length() > 0)) {
					sql1.execSQL("insert into student1 values('" + gPatient
							+ "','" + gAge + "');");
					Intent i = new Intent(MainActivity1.this,Date.class);
					
					startActivity(i);

				} else {
					Toast.makeText(getApplicationContext(),
							"Fill the Above Fields", Toast.LENGTH_LONG).show();

				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity1, menu);
		return true;
	}

}
