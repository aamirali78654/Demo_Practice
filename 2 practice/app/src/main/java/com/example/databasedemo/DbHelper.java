package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper
   {
       //===========DataBase Create in offline===============>>
       static String  DATABASE_NAME = "Practice_db";
       static int DATABASE_VERSION = 1;
       public DbHelper(@Nullable Context context) {
           super(context, DATABASE_NAME, null, DATABASE_VERSION);
       }

       @Override
       public void onCreate(SQLiteDatabase db) {
           String Name_db = "CREATE TABLE registers (id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT, email TEXT,password TEXT,gender TEXT) ";
           db.execSQL(Name_db);

       }

       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("DROP TABLE IF EXISTS registers");
           onCreate(db);
       }
       public boolean registerUserD(String name1, String email, String pass, String gender)
       {
           SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
           ContentValues contentValues = new ContentValues();
           contentValues.put("name",name1);
           contentValues.put("email",email);
           contentValues.put("password",pass);
           contentValues.put("gender",gender);

          long l = sqLiteDatabase.insert("",null,contentValues);
           sqLiteDatabase.close();
           if(l>0)
           {
               return true;
           }
           else {
               return false;
           }
       }
   }
