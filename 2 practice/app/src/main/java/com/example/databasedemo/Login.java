package com.example.databasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText log_email, log_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        log_email = findViewById(R.id.log_email);
        log_password = findViewById(R.id.log_password);
    }
    //---------- login button's method ------------>>
    public void loginBtn(View view)
    {
        String email1 = log_email.getText().toString();
        String pass1 = log_password.getText().toString();
        DbHelper dbHelper = new DbHelper(this);
       boolean logged =  dbHelper.loginUser(email1,pass1);

       if(logged)
       {
           Intent intent = new Intent(Login.this, Profile.class);
           intent.putExtra("key_email",email1);
           startActivity(intent);
       }
       else
       {
           Toast.makeText(this, "email and password did not match...!", Toast.LENGTH_SHORT).show();
       }
    }
}