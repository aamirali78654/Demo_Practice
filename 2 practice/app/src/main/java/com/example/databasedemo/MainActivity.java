package com.example.databasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    //-------------login method------------>>
    public void loginStartActivity(View view)
    {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
    //------- Register method ----->>
    public  void registerStartActivity(View view)
    {
        startActivity(new Intent(MainActivity.this, Register.class));
    }
}