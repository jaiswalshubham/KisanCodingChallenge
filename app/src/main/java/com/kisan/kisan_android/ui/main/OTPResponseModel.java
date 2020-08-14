package com.kisan.kisan_android.ui.main;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sentOTPTable")
public class OTPResponseModel {
    @PrimaryKey
    @NonNull
    public String account_sid;
    public String api_version;
    public String body;
    public String date_created;
    public String date_sent;
    public String date_updated;
    public String direction;
    public String error_code;
    public String error_message;
    public String from;
    public String messaging_service_sid;
    public String num_media;
    public String num_segments;
    public String price;
    public String price_unit;
    public String sid;
    public String status;
    public String to;
    public String uri;
    public Long time;
    public String name;
    public String phone_number;
    public String message_send;
}
