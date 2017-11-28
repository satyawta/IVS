package com.example.wta.IVS;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.net.Uri;
import android.widget.MediaController;

import com.example.wta.IVS.adapters.RecyclerviewCourses;
//import com.example.wta.IVS.adapters.RecyclerviewVideos;
import com.example.wta.IVS.models.Model;
import com.example.wta.IVS.models.video_model;
import com.example.wta.IVS.networkCall.NetworkClass;
import com.example.wta.IVS.videos.config;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by WTA
 * 16/11/2017.
 */
/*30:D7:F2:39:17:E4:A3:85:7C:33:14:7C:C5:7E:BA:1D:48:5B:76:B0

        AIzaSyAWPApjHydbWnVkTVNXuIJ0lOPwKFg2QZQ*/
public class payment_teacher_videos extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    String vidAddress = "https://player.vimeo.com/external/230901816.hd.mp4?s=57e7b343a87f006b4f8bd781ea56f54dc09ee9b9&profile_id=174";
    String vidAddress2 = "https://player.vimeo.com/external/230900892.hd.mp4?s=94918feec344ce9a0504482b874663d312a3a371&profile_id=174";
    private List<video_model> videos=new ArrayList<video_model>();
    private List<Model> modelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerviewCourses mAdapter;
    ArrayList<HashMap<String, String>> video;
    TextView about,classnumber;
    String videoUrl;
    private static final int RECOVERY_REQUEST = 1;
    private ImageView youTubeView;
    private VideoView vimeoView;
    String videocode,class_id,class_page_link,class_page_matadata,class_page_description,class_teacher,class_language,class_name,class_description,class_cover,class_cost,class_duration,select_video_type,video_code,class_status;;
    ImageView img;
    Uri vidUri = Uri.parse(vidAddress);


    private ProgressDialog pDialog;

    private NavigationView navigationView;
    protected DrawerLayout drawer;
    private android.support.v7.widget.Toolbar toolbar;

    private Button aboutBtn,videoBtn;
    View videoView ;
    RelativeLayout aboutView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_teacher_video_nav);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.navigationView);

        aboutBtn =(Button) findViewById(R.id.about);
        videoBtn =(Button) findViewById(R.id.videos);

        videoView = findViewById(R.id.videoview);
        aboutView = (RelativeLayout)findViewById(R.id.aboutview);
        video=new ArrayList<>();

        mAdapter = new RecyclerviewCourses(modelList,this);
      /* recyclerView =(RecyclerView)findViewById(R.id.videos_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(new RecyclerviewCourses.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                System.out.println("clicked === "+position);
                Intent i=new Intent(payment_teacher_videos.this,teacher_profile.class);
                //i.putExtra("videocode",modelList.get(position).getVideo_code());
                Uri vidUri = Uri.parse(vidAddress2);
                startActivity(i);
            }
        });*/



        //youTubeView = findViewById(R.id.image_course_video);
        //youTubeView.initialize(config.YOUTUBE_API_KEY, this);
        vimeoView = findViewById(R.id.imagevideo);
        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(vimeoView);
        vimeoView.setMediaController(vidControl);
        vimeoView.setVideoURI(vidUri);
        vimeoView.start();
        // about = findViewById(R.id.about_course_video);
        classnumber=findViewById(R.id.classnumber_video_course);

        img=findViewById(R.id.videoimage);

//        about.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), payment_teacher_course.class);
//                startActivity(intent);
//            }
//        });

        //getData();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        TextView profile=header.findViewById(R.id.profile_view);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),user_profile.class);
                startActivity(intent);
            }
        });

    }

    public void aboutBtn(View view)
    {
        aboutBtn.setBackgroundResource(R.drawable.my_button_bg);
        videoBtn.setBackgroundColor(getResources().getColor(R.color.white));

        aboutView.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.INVISIBLE);
    }

    public void videoBtn(View view)
    {
        videoBtn.setBackgroundResource(R.drawable.my_button_bg);
        aboutBtn.setBackgroundColor(getResources().getColor(R.color.white));

        videoView.setVisibility(View.VISIBLE);
        aboutView.setVisibility(View.INVISIBLE);

    }
    private void getData() {
        NetworkClass.get("http://indianvedicschool.com/apis/get_courses.php", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    System.out.println("data is" + responseData);
                    try {
                        JSONObject jsonbject = new JSONObject(responseData);

                        videocode = jsonbject.getString("video_code");

                        System.out.println("code is  " + videocode);
                        String url = "http://www.youtube.com/watch?v=" + videocode;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
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

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.navigationView);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
/*
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(config.YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }
*/

}
