package com.kisan.kisan_android.ui.main;

import android.os.Bundle;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kisan.kisan_android.MainActivity;
import com.kisan.kisan_android.R;
import com.kisan.kisan_android.ui.main.BackGroundTask.Database;
import com.kisan.kisan_android.ui.main.BackGroundTask.OTPDao;
import com.twilio.Twilio;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static android.content.ContentValues.TAG;
import static com.kisan.kisan_android.ui.main.Constants.ACCOUNT_SID;
import static com.kisan.kisan_android.ui.main.Constants.AUTH_TOKEN;


public class SendOTPFragment extends SuperFragment {
    View view;
    TextView sendBtn,messageBody,headerTxt,contactName,contactPhoneNumber,otpText;
    ImageView backBtn;
    Executor myExecutor;
    private OTPDao otpDao;
    Bundle bundle;
    String bodyMessage;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_send_ot, container, false);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        InitUI();
        setListner();
        getBundleData();
        Database database = Database.getInstance(getActivity());
        myExecutor = Executors.newFixedThreadPool(2);
        otpDao = database.OTPDao();
        return view;
    }

    private void getBundleData() {
        bundle = getArguments();
        if(bundle != null){
            contactPhoneNumber.setText(bundle.getString(Constants.PHONE_NUMBER));
            contactName.setText(bundle.getString(Constants.NAME));
        }
        int OTP = (int) System.currentTimeMillis()%1000000;
        String otp = Math.abs(OTP % 1000000) + "";
        otpText.setText(otp);
    }

    private void setListner() {
        sendBtn.setOnClickListener(view -> {
            sendOTP();
        });
        backBtn.setOnClickListener(view -> getFragmentManager().popBackStackImmediate());

    }

    private void InitUI() {
        sendBtn = view.findViewById(R.id.send_btn);
        headerTxt  = view.findViewById(R.id.header_txt);
        headerTxt.setText("Message Screen");
        backBtn = view.findViewById(R.id.back_arrow);
        contactName = view.findViewById(R.id.user_name);
        contactPhoneNumber = view.findViewById(R.id.phone_number);
        otpText = view.findViewById(R.id.otp);
    }


    private void sendOTP() {

        OkHttpClient client = new OkHttpClient();

        String url = "https://"+ACCOUNT_SID+":"+AUTH_TOKEN+"@api.twilio.com/2010-04-01/Accounts/"+ACCOUNT_SID+"/Messages";
        String base64EncodedCredentials = "Basic "
                + Base64.encodeToString(
                (ACCOUNT_SID + ":" + AUTH_TOKEN).getBytes(),
                Base64.NO_WRAP);

        try {
            bodyMessage = "Hi. Your OTP is:" + otpText.getText().toString();
            RequestBody body = new FormBody.Builder()
                    .add("From", "+13139086995")
                    .add("To", bundle.getString(Constants.PHONE_NUMBER))
                    .add("Body", bodyMessage)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .header("Authorization", base64EncodedCredentials)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                ResponseBody responseBody = response.body();
                Log.e("tab",responseBody.string());
                if(response.isSuccessful()){
                    insertItem();
                    Toast.makeText(getContext(),"SMS Send Successfully",Toast.LENGTH_SHORT).show();
                    ((MainActivity)getActivity()).gotoFragment(new HomeFragment(),null,"",getActivity());
                }else Toast.makeText(getContext(),"Oops! an error has occurred",Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }}catch (Exception e){
            e.printStackTrace();
        }
    }

    private void insertItem() {
        OTPResponseModel otpResponseModel = new OTPResponseModel();
        otpResponseModel.time = System.currentTimeMillis();
        otpResponseModel.name = bundle.getString(Constants.NAME);
        otpResponseModel.phone_number = bundle.getString(Constants.PHONE_NUMBER);
        otpResponseModel.message_send = bodyMessage;
        otpResponseModel.account_sid = System.nanoTime() + "";
        myExecutor.execute(() -> otpDao.insert(otpResponseModel));
    }
}


