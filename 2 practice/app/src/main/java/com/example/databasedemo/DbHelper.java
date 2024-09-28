package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
       public boolean registerUserD(String name1, String email1, String pass1, String gender1)
       {
           SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
           ContentValues contentValues = new ContentValues();
           contentValues.put("name",name1);
           contentValues.put("email",email1);
           contentValues.put("password",pass1);
           contentValues.put("gender",gender1);

          long l = sqLiteDatabase.insert("",null,contentValues);
           sqLiteDatabase.close();

           if(l > 0)
           {
               return true;
           }
           else {
               return false;
           }
       }

       public boolean loginUser(String e , String p)
       {
           SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
           Cursor cursor =  sqLiteDatabase.rawQuery("SELECT * FROM registers WHERE email='"+e+"' AND password = '"+p+"'",null);
           if(cursor.moveToFirst())
           {
               return true;
           }
           else
           {
               return false;
           }
       }
   }
