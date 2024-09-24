package com.example.demopractice;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    DbHelper dbHelper;

    EditText reg_name,reg_email, reg_pass, reg_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        reg_email = (EditText) findViewById(R.id.reg_email);
        reg_pass = (EditText) findViewById(R.id.reg_pass);
        reg_gender = (EditText) findViewById(R.id.reg_gender);
        reg_name = (EditText) findViewById(R.id.reg_name);
        dbHelper = new DbHelper(getApplicationContext());
    }

    public void registerUser(View view)
    {
        String name = reg_name.getText().toString();
        String email = reg_email.getText().toString();
        String pass = reg_pass.getText().toString();
        String gender = reg_gender.getText().toString();
        //-----------DbHelper class method----------------------->>
       Boolean b = dbHelper.registerUserHepler( name, email, pass, gender );
       if(b == true)
       {
           Toast.makeText(this, "User Register successfully...!!", Toast.LENGTH_SHORT).show();
           reg_name.setText("");
           reg_email.setText("");
           reg_pass.setText("");
           reg_gender.setText("");
       }
       else {
           Toast.makeText(this, "Error...!", Toast.LENGTH_SHORT).show();
       }
    }
}