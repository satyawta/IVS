package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by WTA
 * 16/11/2017.
 */

public class OnboardingFragment3 extends Fragment {

    ImageView onboarding_s;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onborading_s, container, false);

        onboarding_s = view.findViewById(R.id.onboarding_s);

        onboarding_s.setImageResource(R.drawable.onboarding_s);
        return view;
    }
}
