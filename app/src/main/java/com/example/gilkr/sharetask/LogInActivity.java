package com.example.gilkr.sharetask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LogInActivity extends AppCompatActivity {

    Button logInButton;
    Button signInButton;
    EditText username;
    EditText password;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        user = new User();
        logInButton = (Button) findViewById(R.id.LogInButton);
        signInButton = (Button) findViewById(R.id.SignInButton);
        username = (EditText) findViewById(R.id.userNameText);
        password =  (EditText) findViewById(R.id.passwordText);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean logInSuccessful;
                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();
                logInSuccessful = user.VerifyUser(usernameText,passwordText);
                if (logInSuccessful) {
                    Toast.makeText(LogInActivity.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(LogInActivity.this, "No Such User", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                }
            }
        });

    }
}
