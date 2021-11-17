package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.movieapp.adapter.PhotosAdapter;
import com.example.movieapp.model.PhotoModel;
import com.example.movieapp.viewmodel.PhotosViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView textView;
    private PhotosAdapter photosAdapter;
    private List<PhotoModel> modelList;
    private PhotosViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        textView = findViewById(R.id.textView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        photosAdapter = new PhotosAdapter(MainActivity.this, modelList);
        recyclerView.setAdapter(photosAdapter);

        viewModel = ViewModelProviders.of(this).get(PhotosViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<PhotoModel>>() {
            @Override
            public void onChanged(List<PhotoModel> photoModels) {
                if(photoModels != null){
                    photosAdapter.setMovieList(photoModels);
                }else {
                    textView.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }
        });

        viewModel.makeApiCall();
    }
}