package com.example.databasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateProfile extends AppCompatActivity {
    TextView up_email;
    EditText up_name, up_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_profile);
        up_email = findViewById(R.id.up_email);
        up_name = findViewById(R.id.up_name);
        up_gender = findViewById(R.id.up_gender);
        userId user = (userId) getIntent().getSerializableExtra("key_update");
        //---------set text by userId class---------------->>
        up_email.setText(user.getEmail());
        up_name.setText(user.getName());
        up_gender.setText(user.getGender());

    }
    public void updateEditProfile(View view)
    {

    }

}