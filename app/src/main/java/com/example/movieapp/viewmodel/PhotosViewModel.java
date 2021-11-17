package com.example.movieapp.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.model.PhotoModel;
import com.example.movieapp.network.APIService;
import com.example.movieapp.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosViewModel extends ViewModel {
    private final MutableLiveData<List<PhotoModel>> photosList;

    public PhotosViewModel() {
        photosList = new MutableLiveData<>();
    }

    public MutableLiveData<List<PhotoModel>> getMoviesListObserver(){
        return photosList;
    }

    public void makeApiCall(){
        APIService apiService = RetroInstance.getRetrofitCLient().create(APIService.class);
        Call<List<PhotoModel>> call = apiService.getPhotosList();
        call.enqueue(new Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<PhotoModel>> call, @NonNull Response<List<PhotoModel>> response) {
                photosList.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<PhotoModel>> call, @NonNull Throwable t) {
                photosList.postValue(null);
            }
        });
    }
}
