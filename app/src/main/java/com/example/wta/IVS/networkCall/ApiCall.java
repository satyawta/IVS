package com.example.wta.IVS.networkCall;



import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by soma on 21-11-2017.
 */

public class ApiCall {

    public static OkHttpClient client = new OkHttpClient();

    public static Call post(String url, String userName, String password , Callback callback)
    {
        RequestBody formBody = new FormBody.Builder()
                .add("username", userName)
                .add("password", password)
                .add("submit","")
                .build();
        Request request = new Request.Builder().url(url).post(formBody).build();

        okhttp3.Call call = client.newCall(request);

        call.enqueue(callback);

        return  call;
    }
}
