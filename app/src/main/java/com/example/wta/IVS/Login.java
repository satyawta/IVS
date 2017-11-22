package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wta.IVS.networkCall.ApiCall;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by WTA
 * 16/11/2017.
 */

public class Login extends Activity{

    Button submit;
    TextView register, forget_password;
    EditText email,password;
    String usernameresult,passwordresult,result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppEventsLogger.activateApp(this);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.login);

        submit = findViewById(R.id.login);
        register=findViewById(R.id.register);
        forget_password = findViewById(R.id.forgetpassword);
        email=findViewById(R.id.email);
        password=findViewById(R.id.loginpassword);
        submit.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          usernameresult = email.getText().toString();
                                          passwordresult = password.getText().toString();
                                          ApiCall.post("http://indianvedicschool.com/login_api.php", usernameresult, passwordresult, new Callback() {
                                              @Override
                                              public void onFailure(Call call, IOException e) {
                                              }
                                              @Override
                                              public void onResponse(Call call, Response response) throws IOException {
                                                  if (response.isSuccessful()) {
                                                      String responsedata = response.body().string();
                                                      if (responsedata.equalsIgnoreCase("true")) {
                                                          Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                          startActivity(intent);
                                                      } else {
                                                          runOnUiThread(new Runnable() {
                                                              @Override
                                                              public void run() {
                                                                  Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_LONG).show();
                                                              }
                                                          });
                                                      }
                                                  }
                                              }
                                          });
                                      }
                                  });

            register.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent1 = new Intent(getApplicationContext(), register.class);
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
                    }