package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

/**
 * Created by soma on 19-11-2017.
 */

public class teacher_profile extends Activity {

    // TextView viewcourse;
    View profile_footer, profileview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_profile);

        profile_footer = findViewById(R.id.profile_footer_teacher);
        profileview = profile_footer.findViewById(R.id.view_course);


        profileview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),teacher_pay_course.class);
                startActivity(intent);
            }
        });
    }
}
