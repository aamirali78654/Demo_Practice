package com.example.databasedemo;

import java.io.Serializable;

public class userId implements Serializable
     {
         private String name;
         private String email;
         private String gender;
         userId(){}

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String getEmail() {
             return email;
         }

         public void setEmail(String email) {
             this.email = email;
         }

         public String getGender() {
             return gender;
         }

         public void setGender(String gender) {
             this.gender = gender;
         }
     }
