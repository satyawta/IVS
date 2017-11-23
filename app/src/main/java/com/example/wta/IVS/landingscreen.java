package com.example.wta.IVS;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.wta.IVS.adapters.courses_adapter;
import com.example.wta.IVS.app.AppController;
import com.example.wta.IVS.models.video_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class landingscreen extends MainActivity {
    ImageView imageView, img;
    CardView cardView;
    private Context mContext;
    private ImageView youTubeView;
    private List<video_model> videos=new ArrayList<video_model>();
    String class_id,class_page_link,class_page_matadata,class_page_description,class_teacher,class_language,class_name,class_description,class_cover,class_cost,class_duration,select_video_type,video_code,class_status;;
    private static String url = "http://indianvedicschool.com/apis/get_courses.php";
    private ListView lv;
    private courses_adapter coursesAdapter;
    private String TAG = payment_teacher_videos.class.getSimpleName();

    ArrayList<HashMap<String, String>> video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingscreen);
        img = findViewById(R.id.landingscreen_image);

        video=new ArrayList<>();

        lv=findViewById(R.id.course_list);

        coursesAdapter = new courses_adapter(this, videos);
        lv.setAdapter(coursesAdapter);

        new GetVideos().execute();


        Bitmap mbitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.books_library_book_photography_copy)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 100, 100, mpaint);// Round Image Corner 100 100 100 100
        img.setImageBitmap(imageRounded);
        final FragmentManager fm = getFragmentManager();
        final languagefragment l = new languagefragment();
        /*lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show(fm, "Dilaog");
            }
        });*/
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
                    JSONArray classes = jsonObj.getJSONArray("classes");
                    for (int i = 0; i < classes.length(); i++) {
                        JSONObject c = classes.getJSONObject(i);
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

                        HashMap<String, String> videos = new HashMap<>();

                        videos.put("class_id", class_id);
                        videos.put("class_cover", class_cover);
                        videos.put("class_name", class_name);
                        videos.put("class_language", class_language);
                        videos.put("class_cost", class_cost);
                        videos.put("class_duration", class_duration);
                        videos.put("video_code", video_code);

                        video.add(videos);
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
            coursesAdapter.notifyDataSetChanged();
            ListAdapter adapter = new SimpleAdapter(
                    landingscreen.this, video,
                    R.layout.card, new String[]{"class_cover", "class_name", "class_duration", "class_cost","class_language"},
                    new int[]{R.id.courseimage, R.id.course_name_grid, R.id.course_duration_text, R.id.course_price_landing,R.id.language_type_english});

            lv.setAdapter(adapter);
        }
    }
}
