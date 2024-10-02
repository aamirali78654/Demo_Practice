package com.example.databasedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {
     TextView pro_name, pro_email, pro_gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        pro_name = findViewById(R.id.pro_name);
        pro_email = findViewById(R.id.pro_email);
        pro_gender = findViewById(R.id.pro_gender);
    }
    public void proButton(View view)
    {

    }
}