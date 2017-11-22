package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by WTA
 * 16/11/2017.
 */

public class payment_teacher_course extends Activity {

    TextView videos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_teacher_course);

        videos=findViewById(R.id.about_Courses);

        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),payment_teacher_videos.class);
                startActivity(intent);
            }
        });

    }
}
