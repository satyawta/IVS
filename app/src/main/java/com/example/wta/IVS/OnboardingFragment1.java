package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import javax.annotation.Nullable;


/**
 * Created by WTA
 * 16/11/2017.
 */

public class OnboardingFragment1 extends Activity {

    /*ImageView onboarding_i;*/
    Button btn;

    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onborading_i, container, false);

        onboarding_i = view.findViewById(R.id.onboarding_i);

        onboarding_i.setImageResource(R.drawable.onboarding_i);
        return view;
    }*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onborading_i);

    /*    btn = findViewById(R.id.onboarding_button_i);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), OnboardingFragment2.class);
                startActivity(intent);
            }
        });*/

    }
}
