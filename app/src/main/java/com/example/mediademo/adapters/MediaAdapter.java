package com.example.mediademo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mediademo.R;
import com.example.mediademo.model.Media;
import com.example.mediademo.utils.VideoPlayerConfig;
import com.example.mediademo.view.ExoPlayerActivity;

import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.CustomViewHolder> {

    private List<Media> media;
    private Context context;
    private int rowLayout;

    public MediaAdapter(List<Media> media, int rowLayout, Context context) {
        this.media = media;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        TextView songName;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            songName = mView.findViewById(R.id.songName);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_media_list, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MediaAdapter.CustomViewHolder holder, int position) {
        holder.songName.setText(media.get(position).getUser());

        holder.songName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = ExoPlayerActivity
                        .getStartIntent(context, VideoPlayerConfig.DEFAULT_VIDEO_URL);
                context.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return media.size();
    }
}
