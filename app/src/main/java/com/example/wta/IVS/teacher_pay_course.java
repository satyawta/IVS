package com.example.wta.IVS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
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


public class teacher_pay_course extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,NavigationView.OnNavigationItemSelectedListener {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    String videos;
    Button buy;

    private NavigationView navigationView;
    protected DrawerLayout drawer;
    private android.support.v7.widget.Toolbar toolbar;

    private RelativeLayout aboutview;
    private RecyclerView recyclerViewVideos;
    private Button about,videosbutton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatCallback appCompatCallback  = new AppCompatCallback() {
            @Override
            public void onSupportActionModeStarted(ActionMode actionMode) {
            }

            @Override
            public void onSupportActionModeFinished(ActionMode actionMode) {
            }

            @Nullable
            @Override
            public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
                return null;
            }
        };



        AppCompatDelegate delegate = AppCompatDelegate.create(this, appCompatCallback);

        delegate.onCreate(savedInstanceState);
        delegate.setContentView(R.layout.payment_teacher_course_pay_nav);

        aboutview = (RelativeLayout)findViewById(R.id.aboutview);
        recyclerViewVideos = (RecyclerView)findViewById(R.id.recyclerview);
        about =(Button) findViewById(R.id.about);
        videosbutton = (Button) findViewById(R.id.videos);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        delegate.setSupportActionBar(toolbar);
        delegate.getSupportActionBar().setDisplayShowHomeEnabled(true);


        //toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(teacher_pay_course.this);
            }
        });

        drawer = findViewById(R.id.navigationView);



        //setContentView(R.layout.payment_teacher_course_pay);
        Intent intent = getIntent();
        videos=intent.getStringExtra("videocode");
        System.out.println("video code ==="+videos);

        youTubeView = (YouTubePlayerView) findViewById(R.id.payment_teacher_image);
        youTubeView.initialize(config.YOUTUBE_API_KEY, this);



        buy = findViewById(R.id.buynow);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), payment.class);
                startActivity(intent);
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void videoClick(View view)
    {
        aboutview.setVisibility(View.INVISIBLE);
        recyclerViewVideos.setVisibility(View.VISIBLE);
        videosbutton.setBackgroundResource(R.drawable.my_button_bg);
        about.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void aboutClick(View view)
    {
        aboutview.setVisibility(View.VISIBLE);
        recyclerViewVideos.setVisibility(View.INVISIBLE);
        videosbutton.setBackgroundColor(getResources().getColor(R.color.white));
        about.setBackgroundResource(R.drawable.my_button_bg);

    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {
            youTubePlayer.cueVideo(videos); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.payment) {
            Toast.makeText(getApplicationContext(), "Payment is clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.about) {
            Toast.makeText(getApplicationContext(), "About is clicked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.contact) {
            Toast.makeText(getApplicationContext(), "Contact is clicked", Toast.LENGTH_SHORT).show();
        }

        drawer = findViewById(R.id.navigationView);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
