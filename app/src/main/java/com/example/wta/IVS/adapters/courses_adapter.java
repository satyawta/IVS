package com.example.wta.IVS.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.wta.IVS.R;
import com.example.wta.IVS.app.AppController;
import com.example.wta.IVS.models.video_model;

import java.util.List;

/**
 * Created by WTA
 * 23/11/2017.
 */

public class courses_adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<video_model> video_models;
    ImageLoader imageLoader= AppController.getInstance().getImageLoader();

    public courses_adapter(Activity activity, List<video_model> video_models) {
        this.activity = activity;
        this.video_models = video_models;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater==null)
            inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
            convertView=inflater.inflate(R.layout.card,null);
        if(imageLoader==null)
            imageLoader=AppController.getInstance().getImageLoader();
        NetworkImageView img=convertView.findViewById(R.id.courseimage);
        TextView course_name=convertView.findViewById(R.id.course_name_grid);
        TextView course_cost=convertView.findViewById(R.id.course_price_landing);
        TextView course_language=convertView.findViewById(R.id.language_type_english);
        TextView course_time=convertView.findViewById(R.id.course_duration_text);

        video_model vd=video_models.get(position);

        img.setImageUrl(vd.getClass_cover(),imageLoader);
        course_name.setText(vd.getClass_name());
        course_cost.setText(vd.getClass_cost());
        course_language.setText(vd.getClass_language());
        course_time.setText(vd.getClass_duration());
        return convertView;
    }

}

