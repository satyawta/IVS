package com.example.wta.IVS;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by WTA
 * 16/11/2017.
 */

public class languagefragment extends DialogFragment {

    Button btnnext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.language_dialog, container, false);

        getDialog().setTitle("Dialog");

        btnnext = view.findViewById(R.id.language_dialog);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_pay_course.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
