package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;


/**
 * Created by WTA
 * 16/11/2017.
 */

public class OnboardingFragment1 extends Activity {

    Button btn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onborading_i);

        btn = findViewById(R.id.onboarding_button_i);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), OnboardingFragment2.class);
                startActivity(intent);
            }
        });

    }
}
