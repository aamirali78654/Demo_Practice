package com.example.databasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
     TextView pro_name, pro_email, pro_gender;
     String email1;
    userId u_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        pro_name = findViewById(R.id.pro_name);
        pro_email = findViewById(R.id.pro_email);
        pro_gender = findViewById(R.id.pro_gender);
        email1 = getIntent().getStringExtra("key_email");

        getUserMethod();
    }
    public void getUserMethod()
    {
        DbHelper dbHelper = new DbHelper(this);
        ArrayList<userId> al = dbHelper.profileLoggedinUser(email1);
        u_id = al.get(0);
       pro_name.setText(u_id.getName());
       pro_email.setText(u_id.getEmail());
       pro_gender.setText(u_id.getGender());

    }
    public void proButton(View view)
    {
        startActivity(new Intent(Profile.this, Login.class));
    }

    public void proAllDetails(View view)
    {
        DbHelper dbHelper = new DbHelper(this);
        ArrayList al =dbHelper.UserALLdetailsHelper();
        Toast.makeText(this, ""+al, Toast.LENGTH_SHORT).show();
    }
    //-------------Update Profile method-------------->>
    public void updateProfile(View view)
    {
        Intent intent = new Intent(Profile.this, UpdateProfile.class);
        intent.putExtra("key_update",u_id);
        startActivity(intent);
    }
}