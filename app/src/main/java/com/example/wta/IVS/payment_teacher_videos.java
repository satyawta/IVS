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
/*30:D7:F2:39:17:E4:A3:85:7C:33:14:7C:C5:7E:BA:1D:48:5B:76:B0

        AIzaSyAWPApjHydbWnVkTVNXuIJ0lOPwKFg2QZQ*/
public class payment_teacher_videos extends Activity {

    TextView about;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_teacher_video);

        about = findViewById(R.id.about_course_video);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), payment_teacher_course.class);
                startActivity(intent);
            }
        });
    }
}
