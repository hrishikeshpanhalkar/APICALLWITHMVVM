package com.example.movieapp.network;

import com.example.movieapp.model.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("posts")
    Call<List<PhotoModel>> getPhotosList();
}
