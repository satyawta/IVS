package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wta.IVS.videos.config;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by WTA
 * 16/11/2017.
 */

public class payment_teacher_course extends Activity{

    TextView videos;
    String videocode;

    /*private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_teacher_course);

       /* Intent intent = getIntent();
         videocode=intent.getStringExtra("videocode");
        System.out.println("video code ==="+videocode);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(config.YOUTUBE_API_KEY, this);*/

        videos=findViewById(R.id.about_Courses);

        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),payment_teacher_videos.class);
                startActivity(intent);
            }
        });

    }
/*@Override
public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {
        youTubePlayer.cueVideo(videocode); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
        }

@Override
public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()) {
        youTubeInitializationResult.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
        String error = String.format("error", youTubeInitializationResult.toString());
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
        }

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
        // Retry initialization if user performed a recovery action
        getYouTubePlayerProvider().initialize(config.YOUTUBE_API_KEY, this);
        }
        }

protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
        }*/
}
