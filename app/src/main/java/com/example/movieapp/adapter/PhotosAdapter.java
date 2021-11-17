package com.example.movieapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.model.PhotoModel;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {

    private final Context context;
    private List<PhotoModel> photoList;

    public PhotosAdapter(Context context, List<PhotoModel> photoList) {
        this.context = context;
        this.photoList = photoList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setMovieList(List<PhotoModel> photoList){
        this.photoList = photoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(photoList.get(position).getTitle());
        holder.textView2.setText(photoList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        if(photoList != null){
            return photoList.size();
        }
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1= itemView.findViewById(R.id.textview1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }
}
