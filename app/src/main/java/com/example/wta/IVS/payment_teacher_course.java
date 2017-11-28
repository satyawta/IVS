package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
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

public class payment_teacher_course extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    Button videos;
    String video;

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    private Button aboutClick,videoClick;
    RelativeLayout aboutView;
    View videoView ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_teacher_course);

        Intent intent = getIntent();
        String video =intent.getStringExtra("videocode");
        System.out.println("video code ==="+video);

        youTubeView = (YouTubePlayerView) findViewById(R.id.payment_teacher_image);
        youTubeView.initialize(config.YOUTUBE_API_KEY, this);

       /* videos=findViewById(R.id.about_Courses);

        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),payment_teacher_videos.class);
                startActivity(intent);
            }
        });*/


    }

    public void aboutBtn(View view)
    {
        aboutClick.setBackgroundResource(R.drawable.my_button_bg);
        videoClick.setBackgroundColor(getResources().getColor(R.color.white));

        aboutView.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
    }

    public void videoBtn(View view)
    {
        videoClick.setBackgroundResource(R.drawable.my_button_bg);
        aboutClick.setBackgroundColor(getResources().getColor(R.color.white));

        videoView.setVisibility(View.VISIBLE);
        aboutView.setVisibility(View.INVISIBLE);

    }
@Override
public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {
        youTubePlayer.cueVideo(video); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
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
        }
}
