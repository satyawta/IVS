package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by WTA
 * 20/11/2017.
 */

public class login_successful extends Activity {

    Button reset_success;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_successful);

        reset_success = findViewById(R.id.login_now);

        reset_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), landingscreen.class);
                startActivity(intent);
            }
        });

    }
}
