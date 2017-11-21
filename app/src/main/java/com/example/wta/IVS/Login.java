package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wta.IVS.networkCall.ApiCall;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.common.api.Response;

import java.io.IOException;

import okhttp3.Callback;


/**
 * Created by WTA
 * 16/11/2017.
 */

public class Login extends Activity {

    Button submit;
    TextView register, forget_password;
    EditText username,password;
    String usernameresult,passwordresult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppEventsLogger.activateApp(this);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.login);

        submit = findViewById(R.id.login);
        register=findViewById(R.id.register);
        forget_password = findViewById(R.id.forgetpassword);
        username=findViewById(R.id.email);
        password=findViewById(R.id.loginpassword);

        usernameresult=username.getText().toString();
        passwordresult=password.getText().toString();



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callService();
                Intent intent = new Intent(getApplicationContext(), landingscreen.class);

                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),register.class);
                startActivity(intent1);
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), reset_password_email.class);
                startActivity(intent);
            }
        });
    }
    public  void callService()
    {
        ApiCall.post("http://indianvedicschool.com/login_api.php", usernameresult, passwordresult, new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println("response" + response.body().string());

                }
            }

            });
        }
}
