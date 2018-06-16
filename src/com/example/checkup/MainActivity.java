package com.example.checkup;

import java.sql.SQLClientInfoException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText n, m, e, p, cp;
	Button s;
	SQLiteDatabase sql;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		n = (EditText) findViewById(R.id.editText1);
		m = (EditText) findViewById(R.id.editText2);
		e = (EditText) findViewById(R.id.editText3);
		p = (EditText) findViewById(R.id.editText4);
		cp = (EditText) findViewById(R.id.editText5);
		s = (Button) findViewById(R.id.button1);
		sql = openOrCreateDatabase("details", MODE_PRIVATE, null);
		sql.execSQL("create table if not exists student(n text,m text,e text,p text,cp text);");
		s.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String gName = n.getText().toString();
				String gMobile = m.getText().toString();
				String gEmail = e.getText().toString();
				String gPass = p.getText().toString();
				String gCpass = cp.getText().toString();
				if ((gName.length() > 0) & (gEmail.length() > 0)
						& (gMobile.length() == 10) & (gPass.length() > 0)
						& (gCpass.length() > 0) & (gPass.equals(gCpass))) {
					sql.execSQL("insert into student values('" + gName + "','"
							+ gMobile + "','" + gEmail + "','" + gPass + "','"
							+ gCpass + "');");

					Intent i = new Intent(MainActivity.this,
							CheckupActivity.class);
					startActivity(i);
					Toast.makeText(getApplicationContext(),
							"SIGN UP SUCCESSFUL", Toast.LENGTH_LONG).show();

				} else {
					Toast.makeText(
							getApplicationContext(),
							"Fill above All fields\nEnter valid number\nyour password&confirm password should match",
							Toast.LENGTH_LONG).show();
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
