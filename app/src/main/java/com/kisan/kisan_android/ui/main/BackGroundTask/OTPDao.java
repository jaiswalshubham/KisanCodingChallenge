package com.kisan.kisan_android.ui.main.BackGroundTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kisan.kisan_android.ui.main.OTPResponseModel;

import java.util.List;

@Dao
public interface OTPDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(OTPResponseModel otpResponseModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<OTPResponseModel> otpResponseModels);

    @Update
    void update(OTPResponseModel otpResponseModel);

    @Delete
    void delete(OTPResponseModel otpResponseModel);

    @Query("Select * from sentOTPTable ORDER BY time")
    LiveData<List<OTPResponseModel>> getSentOTPData();
}
