package com.example.databasedemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
     TextView pro_name, pro_email, pro_gender;
     String email1;
    userId u_id;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        pro_name = findViewById(R.id.pro_name);
        pro_email = findViewById(R.id.pro_email);
        pro_gender = findViewById(R.id.pro_gender);
        email1 = getIntent().getStringExtra("key_email");
        dbHelper = new DbHelper(this);

        getUserMethod();
    }
    public void getUserMethod()
    {
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
    //-----------delete method----------------->>
    public void deleteProfile(View view)
    {
        //===================Dialog Box alert method ======================>>>>
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile Details");
        builder.setMessage("are you want to delete this profile details?");
        //--------Negative Button--------------->>
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //-----------Positive Button------------->>
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean b = dbHelper.deleteProfileHelper(u_id.getEmail());
                if(b)
                {
                    Toast.makeText(Profile.this, "Profile delete successfully...!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Profile.this,MainActivity.class));
                }
                else
                {
                    Toast.makeText(Profile.this, "Failed..", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.show();
    }
}