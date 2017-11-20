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

public class OnboardingFragment2 extends Fragment {

    ImageView onboarding_v;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onborading_v, container, false);

        onboarding_v = view.findViewById(R.id.onboarding_v);

        onboarding_v.setImageResource(R.drawable.onboarding_v);
        return view;
    }
}
