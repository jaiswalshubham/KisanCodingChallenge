package com.kisan.kisan_android.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kisan.kisan_android.R;
import com.kisan.kisan_android.ui.main.BackGroundTask.ViewModel;

import java.util.ArrayList;
import java.util.List;


public class MessageSentListFragment extends SuperFragment {

    View view;
    Context context;
    RecyclerView messageSentRecycler;
    MessageSentAdapter messageSentAdapter;
    ViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_message_sent_list, container, false);
        viewModel = ViewModelProviders.of(getActivity()).get(ViewModel.class);
        InitUI();
        setObserver();
        return view;
    }

    private void setObserver() {
        viewModel.getOTPSentData().observe(this, otpResponseModels -> setAdapter(otpResponseModels));
    }

    private void setAdapter(List<OTPResponseModel> otpResponseModels) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        messageSentAdapter = new MessageSentAdapter(getActivity());
        messageSentRecycler.setLayoutManager(layoutManager);
        messageSentRecycler.setAdapter(messageSentAdapter);
        messageSentAdapter.updateOTPSentData((ArrayList<OTPResponseModel>) otpResponseModels);
    }

    private void InitUI() {
        messageSentRecycler = view.findViewById(R.id.message_sent_recycler);
    }

}
