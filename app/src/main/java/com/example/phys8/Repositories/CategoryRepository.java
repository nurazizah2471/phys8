package com.example.phys8.Repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.Categories;
import com.example.phys8.Retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private static CategoryRepository categoryRepository;
    private ApiService apiService;

    private CategoryRepository(String token){
        apiService = ApiService.getInstance(token);
    }

    public static CategoryRepository getInstance(String token){
        if (categoryRepository == null){
            categoryRepository = new CategoryRepository(token);
        }
        return categoryRepository;
    }

    public synchronized void resetInstance(){
        if (categoryRepository != null){
            categoryRepository = null;
        }else {
            categoryRepository = null;
        }
    }

    public MutableLiveData<Categories> getCategories(){
        final MutableLiveData<Categories> listCategories = new MutableLiveData<>();

        apiService.getCategories().enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {

                if (response.isSuccessful()){
                    if (response.body() != null){
                        listCategories.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
            }
        });

        return listCategories;
    }
}
