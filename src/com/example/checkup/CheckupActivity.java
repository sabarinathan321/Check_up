package com.example.checkup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CheckupActivity extends Activity {
	EditText u, p;
	Button l, s;
	SQLiteDatabase sql;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkup);
		u = (EditText) findViewById(R.id.editText1);
		p = (EditText) findViewById(R.id.editText2);
		l = (Button) findViewById(R.id.button1);
		s = (Button) findViewById(R.id.button2);
		sql = openOrCreateDatabase("details", MODE_PRIVATE, null);
		sql.execSQL("create table if not exists student(n text,m text,e text,p text,cp text);");
		l.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String gName = u.getText().toString();
				String gPass = p.getText().toString();
				try {
					Cursor c = sql.rawQuery("select p from student where e='"
							+ gName + "';", null);
					if (c != null) {
						String getting = null;
						if (c.moveToFirst()) {
							do {
								getting = c.getString(0);
							} while (c.moveToNext());
						}
						if (gPass.equals(getting)) {
							Intent i = new Intent(CheckupActivity.this,
									MainActivity1.class);
							startActivity(i);
							Toast.makeText(CheckupActivity.this, "SUCESSFULL",
									Toast.LENGTH_LONG).show();

						} else {
							Toast.makeText(CheckupActivity.this,
									"incorrect username or Password",
									Toast.LENGTH_LONG).show();

						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					Toast.makeText(getApplicationContext(), "error=" + e,
							Toast.LENGTH_LONG).show();
				}

			}
		});

		s.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(CheckupActivity.this, MainActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.checkup, menu);
		return true;
	}

}
