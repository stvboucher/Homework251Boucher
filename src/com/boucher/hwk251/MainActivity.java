package com.boucher.hwk251;

import com.example.hwk1.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText emailEditText;
	EditText passwordEditText;
	Button signInButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();

        emailEditText = (EditText) findViewById(R.id.email_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        
        signInButton = (Button) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				int indexOfAt = -1;
				int indexOfPeriod = -1;
				String email = emailEditText.getText().toString();
				String password = passwordEditText.getText().toString();
				
				indexOfAt = email.indexOf("@");
				if (indexOfAt != -1) {
					indexOfPeriod = email.indexOf(".", indexOfAt);				
				}
				
				if (email.isEmpty()) {
					Toast.makeText(getApplicationContext(), "Email address is empty!", Toast.LENGTH_LONG).show();					
				}
     			/* Check that email is in the format [user]@[domain].  Minimum complexity checked: a@b.c.  Ensure
				   that (1) there is at least one letter before "@", (2) a "." follows the "@" by at least 
				   two spots, and (3) at least one letter follows the "."  */
				else if ((indexOfAt < 1) || (indexOfPeriod < indexOfAt + 2) ||
					     (indexOfPeriod > email.length() - 2) ) {
					Toast.makeText(getApplicationContext(), "Email address has an invalid format", Toast.LENGTH_LONG).show();
				} else if (password.isEmpty()) {
					Toast.makeText(getApplicationContext(), "Password field is empty!", Toast.LENGTH_LONG).show();					
				} else { 
					// Display confirmation screen
		            Intent intent = new Intent(getBaseContext(), ConfirmationActivity.class);
		            intent.putExtra("email", email);
		            intent.putExtra("password", password);
		            startActivity(intent);		           					
				}				
			}        	
        });
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
       
}
