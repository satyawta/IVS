package com.example.wta.IVS;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
public class payment_teacher_videos extends AppCompatActivity  {

    TextView about,classnumber;
    String videoUrl;
    private static final int RECOVERY_REQUEST = 1;
    private ImageView youTubeView;
    String videocode,class_id,class_page_link,class_page_matadata,class_page_description,class_teacher,class_language,class_name,class_description,class_cover,class_cost,class_duration,select_video_type,video_code,class_status;;
    ImageView img;


    private ProgressDialog pDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_teacher_video);


        youTubeView = findViewById(R.id.image_course_video);
        //youTubeView.initialize(config.YOUTUBE_API_KEY, this);

         about = findViewById(R.id.about_course_video);
         classnumber=findViewById(R.id.classnumber_video_course);

         img=findViewById(R.id.videoimage);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), payment_teacher_course.class);
                startActivity(intent);
            }
        });

        //getData();
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
