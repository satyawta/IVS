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
import com.example.wta.IVS.util.Constants;

import java.util.List;

/**
 * Created by somas on 22-11-2017.
 */

public class RecyclerviewVideos extends RecyclerView.Adapter<RecyclerviewVideos.MyViewHolder>
{
    private List<Model> model;
    Context context;

    public RecyclerviewVideos(List<Model> model, Context context)
    {
       this.model=model;
       this.context=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public ImageView imageView;
        public TextView classname,desc,time;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.video_thumbnail);
            classname=(TextView)itemView.findViewById(R.id.classno);
            desc =(TextView)itemView.findViewById(R.id.desc);
            time = (TextView)itemView.findViewById(R.id.time);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.videosrow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.desc.setText(model.get(position).getClass_page_description());
        holder.time.setText(model.get(position).getClass_duration());
        String imagecode = model.get(position).getClass_cover();
        String imageurl = Constants.ImageUrl+imagecode;
        System.out.println("image url === "+imageurl);
        Glide.with(context).load(imageurl).centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }


}
