package com.example.instagram_daniel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //getting access to the "widgets" on the xml file
        final EditText usernameInput = findViewById(R.id.etUsername);
        final EditText passwordInput = findViewById(R.id.etPassword);
        Button logInBtn = findViewById(R.id.btnLogin);

        //Listener allows us to press the button with some action attached to it
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the values entered from user and send them to parse server login
                final String username = usernameInput.getText().toString();
                final String password = passwordInput.getText().toString();

                userLogIn(username,password);
            }
        });
    }

    private void userLogIn(String userName, String userPassword)
    {
        //One big set up for the parse server connection, no real authentication
        ParseUser.logInInBackground(userName, userPassword, new LogInCallback()
        {
            @Override
            public void done(ParseUser user, ParseException e)
            {
                //no errors are found
                if(e == null)
                {
                    Log.d("LogInActivity", "Log in successful");
                    //Should not be directed to Main Activity, placeholder for now
                    final Intent screen = new Intent(LogInActivity.this, MainActivity.class);
                    startActivity(screen);
                }
                else
                {
                    //errors are found and logged
                    Log.e("LogInActivity", "Log in failed");
                    e.printStackTrace();
                }
            }
        });
    }
}
