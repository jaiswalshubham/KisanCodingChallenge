package com.kisan.kisan_android.ui.main;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.kisan.kisan_android.R;
import com.kisan.kisan_android.ui.main.BackGroundTask.ContactDisplayDao;
import com.kisan.kisan_android.ui.main.BackGroundTask.Database;
import com.kisan.kisan_android.ui.main.BackGroundTask.ViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends SuperFragment {
    View view;
    List<ContactModel> contactModelList = new ArrayList<ContactModel>();
    SectionsPagerAdapter adapter;
    private ContactDisplayDao contactDisplayDao;
    LiveData<List<ContactModel>> con;
    ViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view == null){
            view = inflater.inflate(R.layout.fragment_home, container, false);
            Database database = Database.getInstance(getActivity());
            contactDisplayDao = database.contactDisplay();
            viewModel = ViewModelProviders.of(getActivity()).get(ViewModel.class);
            ContactModel contactModel = new ContactModel();
            contactModel.id = System.nanoTime() +"";
            contactModel.phone_number = "+917007098911";
            contactModel.name = "Anil Kr. Sahu";
            ContactModel contactModel1 = new ContactModel();
            contactModel1.id = System.nanoTime() + 100 +"";
            contactModel1.phone_number =  "+918604149974";
            contactModel1.name = "Aruna Sahu";
            ContactModel contactModel2 = new ContactModel();
            contactModel2.id = System.nanoTime() +1 + "";
            contactModel2.name = "Shivam Jaiswal";
            contactModel2.phone_number = "+918932825430";
            ContactModel contactModel3 = new ContactModel();
            contactModel3.id = System.nanoTime() + "";
            contactModel3.phone_number = "+918932085430";
            contactModel3.name = "Shubham Jaiswal";
            contactModelList.add(contactModel);
            contactModelList.add(contactModel1);
            contactModelList.add(contactModel2);
            contactModelList.add(contactModel3);
            viewModel.insertAllContactData(contactModelList);
            setObserver();

            FloatingActionButton fab = view.findViewById(R.id.fab);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                    View mView = getLayoutInflater().inflate(R.layout.dialog_add, null);
                    final EditText editText_mUserName = (EditText) mView.findViewById(R.id.user_name);
                    final EditText userPhone = (EditText) mView.findViewById(R.id.user_contact);
                    RelativeLayout mAdd = (RelativeLayout) mView.findViewById(R.id.btnadd);
                    mBuilder.setView(mView);
                    //create dialog instance here, so that it can be dismissed from within the OnClickListener callback
                    final AlertDialog dialog = mBuilder.create();

                    mAdd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (CommonUtil.isValidString(editText_mUserName.getText().toString()) && CommonUtil.isValidMobile(userPhone.getText().toString())) {
                                // Instead of et.getText(), call mUser.getText()
                                String result = editText_mUserName.getText().toString();
                                ContactModel contactModel = new ContactModel();
                                contactModel.phone_number ="+91"+userPhone.getText().toString();
                                contactModel.id = System.nanoTime() + "";
                                contactModel.name = editText_mUserName.getText().toString();
                                contactModelList.add(contactModel);
                                setAdapter(contactModelList);
                                viewModel.insertContactData(contactModel);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                                //dismiss dialog once item is added successfully
                                dialog.dismiss();
                            } else {
                                Toast.makeText(getActivity(), "Error pls Write", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    dialog.show();
                }
            });
        }
        return view;
    }

    private void setObserver() {
        viewModel.getContactData().observe(this, contactModels -> setAdapter(contactModels));
    }

    private void setAdapter(List<ContactModel> contactModelList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.CONTACT_LIST,(Serializable) this.contactModelList);
        adapter = new SectionsPagerAdapter(getChildFragmentManager(), bundle, getActivity(), this);
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }


}
