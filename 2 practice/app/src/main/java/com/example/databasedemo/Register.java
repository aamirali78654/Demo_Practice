package com.example.databasedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText reg_name , reg_password, reg_email, reg_gender;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        reg_name = findViewById(R.id.reg_name);
        reg_email = findViewById(R.id.reg_email);
        reg_password = findViewById(R.id.reg_password);
        reg_gender = findViewById(R.id.reg_gender);
        dbHelper = new DbHelper(getApplicationContext());

    }
    public void registerBtn(View view)
    {
        String name = reg_name.getText().toString();
        String email = reg_email.getText().toString();
        String password = reg_password.getText().toString();
        String gender = reg_gender.getText().toString();
        //---------SQLiteDataBase call-------------->>
       boolean b = dbHelper.registerUserD(name, email, password, gender);
       if(b)
       {
           Toast.makeText(this, "User Successfully Register...!", Toast.LENGTH_SHORT).show();
           reg_name.setText("");
           reg_email.setText("");
           reg_password.setText("");
           reg_gender.setText("");
       }
       else
       {
           Toast.makeText(this, "ERROR...!", Toast.LENGTH_SHORT).show();
       }
    }
}