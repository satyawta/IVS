package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by soma on 19-11-2017.
 */

public class teacher_profile extends Activity {

        TextView viewcourse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewcourse = findViewById(R.id.view_course);

        viewcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),teacher_pay_course.class);
                startActivity(intent);
            }
        });
    }
}
