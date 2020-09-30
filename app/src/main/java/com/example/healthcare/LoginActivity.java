package com.example.healthcare;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button signin;
    private Button login;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText)findViewById(R.id.userNameEditText);
        password = (EditText)findViewById(R.id.editTextTextPassword);
        info = (TextView)findViewById(R.id.textViewInfo);
        login = (Button)findViewById(R.id.button_login);
        signin = (Button)findViewById(R.id.SignInbutton);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validate(username.getText().toString(), password.getText().toString());
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });



    }

    private void Validate(String Username, String Password){
        if( Username == "Admin" ){
            if(Password == "1234") {
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        }
        else{

        }
    }
}
