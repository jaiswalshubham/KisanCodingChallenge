package com.kisan.kisan_android.ui.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kisan.kisan_android.R;
import com.kisan.kisan_android.ui.main.BackGroundTask.ContactDisplayDao;
import com.kisan.kisan_android.ui.main.BackGroundTask.ContactListModel;

import java.util.List;


public class ContactListFragment extends SuperFragment {

    RecyclerView contactRecycler;
    View view;
    ContactAdapter contactAdapter;
    LinearLayoutManager layoutManager;
    List<ContactModel> contactModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        InitUI();
        setAdapter();

        return view;
    }
    private void setAdapter() {
        Bundle bundle = getArguments();

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        contactAdapter = new ContactAdapter(getActivity());
        contactRecycler.setLayoutManager(layoutManager);
        contactRecycler.setAdapter(contactAdapter);
        if(bundle != null){
            contactModelList = (List<ContactModel>) bundle.getSerializable(Constants.CONTACT_LIST);
            contactAdapter.updateContactList(contactModelList);
        }

    }

    private void InitUI() {
        contactRecycler = view.findViewById(R.id.contact_list_recycler);
    }
}
