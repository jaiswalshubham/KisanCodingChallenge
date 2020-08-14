package com.kisan.kisan_android.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kisan.kisan_android.MainActivity;
import com.kisan.kisan_android.R;


public class ContactDetailsFragment extends SuperFragment {
    Context context;
    View view;
    TextView name,phone,sendBtn;
    ImageView backArrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact_details, container, false);
        InitUI();
        setListener();
        return view;
    }

    private void setListener() {
        Bundle bundle = getArguments();
        if(bundle != null){
            name.setText(bundle.getString(Constants.NAME));
            phone.setText(bundle.getString(Constants.PHONE_NUMBER));
        }
        sendBtn.setOnClickListener(view -> ((MainActivity)getActivity()).gotoFragment(new SendOTPFragment(),bundle,"ContactDetailsFragment",getActivity()));
        backArrow.setOnClickListener(view -> getFragmentManager().popBackStackImmediate());
    }

    private void InitUI() {
        sendBtn = view.findViewById(R.id.send_btn);
        backArrow = view.findViewById(R.id.back_arrow);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone_number);

    }

}
