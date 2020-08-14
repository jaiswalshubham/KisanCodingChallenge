package com.kisan.kisan_android.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kisan.kisan_android.MainActivity;
import com.kisan.kisan_android.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    Context context;
    View view;
    List<ContactModel> contactModelList;


    public ContactAdapter(Context context) {
        this.context = context;
    }
    public void updateContactList( List<ContactModel> contactModelList){
        this.contactModelList = contactModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater != null ? inflater.inflate(R.layout.adapter_contact_details, parent, false) : null;
        return new ContactAdapter.ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {

        Bundle bundle = new Bundle();
        bundle.putString(Constants.NAME,contactModelList.get(position).name);
        bundle.putString(Constants.PHONE_NUMBER,contactModelList.get(position).phone_number);
        holder.adapterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).gotoFragment(new ContactDetailsFragment(),bundle,"MainActivity",context);
            }
        });
        holder.name.setText(contactModelList.get(position).name);
        holder.phoneNumber.setText(contactModelList.get(position).phone_number);
    }

    @Override
    public int getItemCount() {
        if(contactModelList == null){
            return 0;
        }else return contactModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout adapterLayout;
        TextView name,phoneNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adapterLayout = itemView.findViewById(R.id.contact_adapter_layout);
            name = itemView.findViewById(R.id.user_name);
            phoneNumber = itemView.findViewById(R.id.phone_number);

        }
    }
}
