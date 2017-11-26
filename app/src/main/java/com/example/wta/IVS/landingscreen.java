package com.example.wta.IVS;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.wta.IVS.adapters.RecyclerviewCourses;
import com.example.wta.IVS.app.AppController;
import com.example.wta.IVS.models.Model;
import com.example.wta.IVS.models.video_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

public class landingscreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView img;
    TextView classname;
    private List<video_model> videos=new ArrayList<video_model>();
    public String class_id,class_page_link,class_page_matadata,class_page_description,class_teacher,class_language,class_name,class_description,class_cover,class_cost,class_duration,select_video_type,video_code,class_status;;
    private static String url = "http://indianvedicschool.com/apis/get_courses.php";
    private String TAG = payment_teacher_videos.class.getSimpleName();

    ArrayList<HashMap<String, String>> video;

    Model model;

    String videocode;
    private List<Model> modelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerviewCourses mAdapter;

    private NavigationView navigationView;
    protected DrawerLayout drawer;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_profile_nav);
        navigationView = findViewById(R.id.nav_view);
        img = findViewById(R.id.landingscreen_image);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.navigationView);


        video=new ArrayList<>();

        mAdapter = new RecyclerviewCourses(modelList,this);
        recyclerView =(RecyclerView)findViewById(R.id.course_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setClickListener(new RecyclerviewCourses.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                System.out.println("clicked === "+position);
                final FragmentManager fm = getFragmentManager();
                final languagefragment l = new languagefragment();
                Bundle b=new Bundle();
                b.putString("videocode",modelList.get(position).getVideo_code());
                l.setArguments(b);
                l.show(fm, "Dialog");
                // l.setArguments(modelList.get(position).getVideo_code());
                /*Intent i=new Intent(landingscreen.this,teacher_profile.class);
                i.putExtra("videocode",modelList.get(position).getVideo_code());
                startActivity(i);*/
            }
        });

        new GetVideos().execute();


        Bitmap mbitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.books_library_book_photography_copy)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 100, 100, mpaint);// Round Image Corner 100 100 100 100
        img.setImageBitmap(imageRounded);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.payment) {
            Toast.makeText(getApplicationContext(), "Payment is clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.about) {
            Intent intent=new Intent(getApplicationContext(),about_ivs.class);
            startActivity(intent);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       /* if (item != null && item.getItemId() == android.R.id.home) {
            if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                drawer.closeDrawer(Gravity.RIGHT);
            }
            else {
                drawer.openDrawer(Gravity.RIGHT);
            }
        }
        return false;*/
        return super.onOptionsItemSelected(item);

    }


    private class GetVideos extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray jsonArray = jsonObj.getJSONArray("classes");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        model=new Model();
                        JSONObject c = jsonArray.getJSONObject(i);
                        class_id = c.getString("class_id");
                        class_page_link = c.getString("class_page_link");
                        class_page_matadata = c.getString("class_page_matadata");
                        class_page_description = c.getString("class_page_description");
                        class_teacher = c.getString("class_teacher");
                        class_language = c.getString("class_language");
                        class_name = c.getString("class_name");
                        class_description = c.getString("class_description");
                        class_cover = c.getString("class_cover");
                        class_cost = c.getString("class_cost");
                        class_duration = c.getString("class_duration");
                        select_video_type = c.getString("select_video_type");
                        video_code = c.getString("video_code");
                        class_status = c.getString("class_status");

                        videocode = jsonArray.getJSONObject(i).getString("video_code");
                        model.setVideo_code(videocode);
                        model.setClass_id(jsonArray.getJSONObject(i).getString("class_id"));
                        model.setClass_name(jsonArray.getJSONObject(i).getString("class_name"));
                        model.setClass_cover(jsonArray.getJSONObject(i).getString("class_cover"));
                        model.setClass_language(jsonArray.getJSONObject(i).getString("class_language"));
                        model.setClass_cost(jsonArray.getJSONObject(i).getString("class_cost"));
                        model.setClass_page_description(jsonArray.getJSONObject(i).getString("class_page_description"));
                        model.setClass_duration(jsonArray.getJSONObject(i).getString("class_duration"));

                        modelList.add(model);
                    }
                } catch (final JSONException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            mAdapter.notifyDataSetChanged();

        }
    }

}
