package com.kisan.kisan_android.ui.main;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "contactList")
public class ContactModel implements Serializable {
    @PrimaryKey
    @NonNull
    public String id;
   public String name;
   public String phone_number;
}
