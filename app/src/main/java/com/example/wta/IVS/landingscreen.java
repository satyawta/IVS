package com.example.wta.IVS;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class landingscreen extends MainActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingscreen);

        final FragmentManager fm = getFragmentManager();
        final languagefragment l = new languagefragment();
        imageView = findViewById(R.id.courseimage_1);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show(fm, "Dilaog");
            }
        });
    }
}
