package com.kisan.kisan_android.ui.main.BackGroundTask;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kisan.kisan_android.ui.main.Constants;
import com.kisan.kisan_android.ui.main.ContactModel;
import com.kisan.kisan_android.ui.main.OTPResponseModel;

@androidx.room.Database(entities = {OTPResponseModel.class, ContactModel.class},version = 1)
public abstract class Database extends RoomDatabase{
    private static final String DB_NAME = Constants.DB_NAME;
    public  abstract OTPDao OTPDao();
    public abstract ContactDisplayDao contactDisplay();

    private static Database instance;

    public static synchronized Database getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
