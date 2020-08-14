package com.kisan.kisan_android.ui.main.BackGroundTask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kisan.kisan_android.ui.main.ContactModel;
import com.kisan.kisan_android.ui.main.OTPResponseModel;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private  ContactDisplayDao displayDao;
    Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        Database database = Database.getInstance(application);
        displayDao = database.contactDisplay();
        this.repository = new Repository(application);
    }

    public  LiveData<List<ContactModel>> getContactData(){
        return repository.getContactData();
    }
    public  LiveData<List<OTPResponseModel>> getOTPSentData(){
        return repository.getOTPData();
    }

    public void insertContactData(ContactModel contactModel) {
        repository.insertContactData(contactModel);
    }
    public void insertAllContactData(List<ContactModel> contactModel) {
        repository.insertAllContactData(contactModel);
    }
}
