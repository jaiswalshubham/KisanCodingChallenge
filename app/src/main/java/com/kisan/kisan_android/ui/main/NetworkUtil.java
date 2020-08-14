package com.kisan.kisan_android.ui.main;

import android.util.Log;


import com.google.android.gms.common.api.Status;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;



public class NetworkUtil {

/*
    private static NetworkUtil instance;
    private OkHttpClient client;

    private NetworkUtil() {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .dispatcher(new Dispatcher())
                .build();
    }

    private static NetworkUtil getInstance() {
        if (instance == null) instance = new NetworkUtil();
        return instance;
    }

    public static void callAPI( Object requestBody, String mTo,String mBody) {
        Status errorStatus = null;
        try {
            HttpUrl.Builder httpUrlBuilder = HttpUrl.parse("gg").newBuilder();

            HttpUrl httpUrl = httpUrlBuilder.build();

            NetworkUtil util = getInstance();
            Request request = null;
            RequestBody formBody = new FormBody.Builder()
                    .add("To", mTo)
                    .add("Body", mBody)
                    .build();
            request = new Request.Builder()
                    .url(httpUrl)
                    .post(formBody)
                    .build();

            util.client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                   e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        if (response != null) {
                            String responseStr;
                            ResponseBody responseBody = response.body();
                            if (response.isSuccessful() && responseBody != null) {
                                responseStr = responseBody.string();
                                Log.d("NetworkUtil ==> ", "Response : " + responseStr);

                            }

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

*/

}
