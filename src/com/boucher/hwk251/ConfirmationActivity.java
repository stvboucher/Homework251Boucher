package com.boucher.hwk251;

import com.example.hwk1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirmation);
        getActionBar().hide();
		
		Intent intent = this.getIntent();
		if (intent != null) {
			String emailString = intent.getStringExtra("email");
			String passwordString = intent.getStringExtra("password");
	        
			TextView emailTextView = (TextView) findViewById(R.id.email_text_view);
	        TextView passwordTextView = (TextView) findViewById(R.id.password_text_view);
	        
	        if ((emailTextView != null) && passwordTextView != null) {
	        	emailTextView.setText(emailString);	        
		        passwordTextView.setText(passwordString);	
	        }	        
		}       
	}    
}

