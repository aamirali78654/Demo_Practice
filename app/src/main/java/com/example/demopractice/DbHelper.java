package com.example.demopractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper
  {
      private static final String DATABASE_NAME = "demo_db";
      private static final int DATABASE_VERSION = 1;
      //----------DbHelper's Constructor----------->>
      public DbHelper(@Nullable Context context)
      {
          super(context, DATABASE_NAME, null, DATABASE_VERSION);
      }

      @Override
      public void onCreate(SQLiteDatabase db)
      {
          String CREATE_TABLE_QUERY = "CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT, email TEXT, password TEXT, gender TEXT)";
          db.execSQL(CREATE_TABLE_QUERY);

      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
      {
          db.execSQL("DROP TABLE IF EXISTS register");
          onCreate(db);

      }
      public Boolean registerUserHepler(String name1, String email1, String pass1 , String gender1)
      {

          SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
          ContentValues contentValues = new ContentValues();

          contentValues.put("name",name1);
          contentValues.put("email",email1);
          contentValues.put("password",pass1);
          contentValues.put("gender",gender1);
        Long l =   sqLiteDatabase.insert("register",null,contentValues);
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