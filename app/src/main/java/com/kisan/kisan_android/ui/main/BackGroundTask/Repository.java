package com.kisan.kisan_android.ui.main.BackGroundTask;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.kisan.kisan_android.ui.main.ContactModel;
import com.kisan.kisan_android.ui.main.OTPResponseModel;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Repository {
    Executor myExecutor;
    private ContactDisplayDao contactDisplayDao;
    private OTPDao otpDao;
    public Repository(Context context) {
        Database database = Database.getInstance(context);
        myExecutor = Executors.newFixedThreadPool(2);
        contactDisplayDao = database.contactDisplay();
        otpDao = database.OTPDao();
    }

    LiveData<List<ContactModel>> getContactData(){
        return contactDisplayDao.getAllContactList();
    }

    public void insertContactData(ContactModel contactModel) {
        myExecutor.execute(() -> contactDisplayDao.insert(contactModel));
    }

    public void insertAllContactData(List<ContactModel> contactModel) {
        myExecutor.execute(() -> contactDisplayDao.insertAll(contactModel));
    }

    public LiveData<List<OTPResponseModel>> getOTPData() {
        return otpDao.getSentOTPData();
    }
}
