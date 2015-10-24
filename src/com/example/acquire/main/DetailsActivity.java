package com.example.acquire.main;

import com.example.acquire.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends Activity{
	
	private TextView textView_Name;
	private TextView textView_Description;
	
	private EditText editText_CustomName;
	private String lastCustomName;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_details);

		init();
	}

	private void init(){
		textView_Name = (TextView)findViewById(R.id.textView_Name);
		textView_Description = (TextView)findViewById(R.id.textView_Description);
		editText_CustomName = (EditText)findViewById(R.id.editText_CustomName);

		Intent intent = getIntent();

        //Show the information
		String str_name = intent.getStringExtra("name");
		String str_newname = intent.getStringExtra("customName");
		String str_description = intent.getStringExtra("description");

		textView_Name.setText(str_name);
		textView_Description.setText(str_description);
		editText_CustomName.setText(str_newname);
		lastCustomName = editText_CustomName.getText().toString();
	}
	
	public void onButtonClick_ok(View view){
		//Send back the custom name
		String customName = editText_CustomName.getText().toString();
		Intent result=new Intent();
		
		if(customName.length() != 0 && !customName.equals(lastCustomName)){
			result.putExtra("customName", customName);
			setResult(RESULT_OK, result);
			finish();
		}
		
		setResult(RESULT_CANCELED, result);
		finish();
	}
}
