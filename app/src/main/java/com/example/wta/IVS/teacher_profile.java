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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wta.IVS.videos.config;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by soma on 19-11-2017.
 */

public class teacher_profile extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,NavigationView.OnNavigationItemSelectedListener {

    TextView viewcourse;
    View profile_footer, profileview;
    String videocode;

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;


    private NavigationView navigationView;
    protected DrawerLayout drawer;
    private android.support.v7.widget.Toolbar toolbar;

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
        delegate.setContentView(R.layout.teacher_profile_nav);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        delegate.setSupportActionBar(toolbar);
        delegate.getSupportActionBar().setDisplayShowHomeEnabled(true);

        //toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(teacher_profile.this);
            }
        });

        navigationView=findViewById(R.id.nav_view);
        drawer = findViewById(R.id.navigationView);

        //setContentView(R.layout.teacher_profile);
        Intent intent = getIntent();
        videocode=intent.getStringExtra("videocode");
        System.out.println("video code ==="+videocode);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(config.YOUTUBE_API_KEY, this);

        profile_footer = findViewById(R.id.profile_footer_teacher);
        profileview = profile_footer.findViewById(R.id.view_course);

        View header=navigationView.getHeaderView(0);
        TextView profile=header.findViewById(R.id.profile_view);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),user_profile.class);
                startActivity(intent);
            }
        });

        profileview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),teacher_pay_course.class);
                intent.putExtra("videocode",videocode);
                startActivity(intent);
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
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

