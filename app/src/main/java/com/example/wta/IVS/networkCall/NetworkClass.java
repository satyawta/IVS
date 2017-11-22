package com.example.wta.IVS.networkCall;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by WTA
 * 22/11/2017.
 */

public class NetworkClass {

    public static OkHttpClient client = new OkHttpClient();
    public static Call get(String url, Callback callback)
    {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

        return call;
    }

}
