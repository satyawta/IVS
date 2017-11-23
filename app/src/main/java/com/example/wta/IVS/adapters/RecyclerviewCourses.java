package com.example.wta.IVS.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wta.IVS.R;
import com.example.wta.IVS.models.Model;
import com.example.wta.IVS.models.video_model;
import com.example.wta.IVS.util.Constants;

import java.util.List;

/**
 * Created by somas on 23-11-2017.
 */

public class RecyclerviewCourses extends RecyclerView.Adapter<RecyclerviewCourses.MyViewHolder> {
    private List<Model> model;
    Context context;

    private static ClickListener clickListener;

    public RecyclerviewCourses(List<Model> model, Context context) {
        this.model = model;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView;
        public TextView classname, desc, time;
        TextView course_name, course_cost, course_language, course_time;
        ImageView img;

        public MyViewHolder(View convertView) {

            super(convertView);
            img = convertView.findViewById(R.id.courseimage);
            course_name = convertView.findViewById(R.id.course_name_grid);
            course_cost = convertView.findViewById(R.id.course_price_landing);
            course_language = convertView.findViewById(R.id.language_type_english);
            course_time = convertView.findViewById(R.id.course_duration_text);
            convertView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),view);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String imagecode = model.get(position).getClass_cover();
        String imageurl = Constants.ImageUrl + imagecode;
        Glide.with(context).load(imageurl).placeholder(R.drawable.layer_3).override(100, 100).centerCrop().into(holder.img);
        holder.course_name.setText(model.get(position).getClass_name());
        holder.course_cost.setText(model.get(position).getClass_cost());
        holder.course_language.setText(model.get(position).getClass_language());
        holder.course_time.setText(model.get(position).getClass_duration());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public void setClickListener(ClickListener clickListener) {
        RecyclerviewCourses.clickListener = clickListener;
    }
    public interface ClickListener {
        void onItemClick(int position, View v);
    //    void onItemLongClick(int position, View v);
    }

}
