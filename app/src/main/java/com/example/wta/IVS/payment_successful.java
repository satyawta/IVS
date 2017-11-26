package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by WTA
 * 16/11/2017.
 */

public class payment_successful extends AppCompatActivity {

    Button viewcourse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_successful);
        viewcourse = findViewById(R.id.view_course);
        viewcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), payment_teacher_videos.class);
                startActivity(intent);
            }
        });
    }
}
