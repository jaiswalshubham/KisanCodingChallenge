package com.kisan.kisan_android.ui.main.BackGroundTask;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.PrimaryKey;

@Dao
public class ContactListModel {
    @PrimaryKey
    @NonNull
    public String id;
    public String name;
    public String phone_number;
}
