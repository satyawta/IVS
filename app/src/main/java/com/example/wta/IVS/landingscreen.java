package com.example.wta.IVS;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class landingscreen extends MainActivity {
    ImageView imageView, img;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingscreen);

        final FragmentManager fm = getFragmentManager();
        final languagefragment l = new languagefragment();
        imageView = findViewById(R.id.courseimage_1);

        Glide.with(mContext).load(imageView)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show(fm, "Dilaog");
            }
        });
    }
}
