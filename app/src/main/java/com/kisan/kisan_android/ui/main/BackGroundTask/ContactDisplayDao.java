package com.kisan.kisan_android.ui.main.BackGroundTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kisan.kisan_android.ui.main.ContactModel;

import java.util.List;
@Dao
public interface ContactDisplayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ContactModel contactModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ContactModel> otpResponseModels);

    @Update
    void update(ContactModel contactModel);

    @Delete
    void delete(ContactModel contactModel);

    @Query("Select * from contactList")
    LiveData<List<ContactModel>> getAllContactList();
}
