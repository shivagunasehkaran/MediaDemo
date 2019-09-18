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
import com.example.mediademo.view.GalleryDetailActivity;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.CustomViewHolder> {

    private List<Media> media;
    private Context context;
    private int rowLayout;
    private String imageUri;

    public GalleryAdapter(List<Media> media, int rowLayout, Context context) {
        this.media = media;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        TextView imageName;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            imageName = mView.findViewById(R.id.imageName);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_gallery_list, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        imageUri = media.get(position).getLargeImageURL();
        holder.imageName.setText(imageUri);

        holder.imageName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GalleryDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("image_uri", imageUri);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return media.size();
    }
}
