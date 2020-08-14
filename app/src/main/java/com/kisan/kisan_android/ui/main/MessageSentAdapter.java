package com.kisan.kisan_android.ui.main;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.kisan.kisan_android.R;

import java.util.ArrayList;
import java.util.Date;

public class MessageSentAdapter extends RecyclerView.Adapter<MessageSentAdapter.ViewHolder> {

    Context context;
    View view;
    ArrayList<OTPResponseModel> otpResponseModels;

    public MessageSentAdapter(Context context) {
        this.context = context;
    }
    public void updateOTPSentData(ArrayList<OTPResponseModel> otpResponseModels){
        this.otpResponseModels = otpResponseModels;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MessageSentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater != null ? inflater.inflate(R.layout.adapter_message_sent, parent, false) : null;
        return new MessageSentAdapter.ViewHolder(view);     }

    @Override
    public void onBindViewHolder(@NonNull MessageSentAdapter.ViewHolder holder, int position) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd' 'hh:mm:ss");
        String dateString = formatter.format(new Date(otpResponseModels.get(position).time));
        holder.time.setText(dateString);
        holder.messageBody.setText(otpResponseModels.get(position).message_send);
        holder.userName.setText(otpResponseModels.get(position).name);


    }

    @Override
    public int getItemCount() {
        if(otpResponseModels == null)
            return 0;
        else return  otpResponseModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName,messageBody,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            messageBody = itemView.findViewById(R.id.message_body);
            time = itemView.findViewById(R.id.time);
        }
    }
}
