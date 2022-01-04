package com.example.phys8.Repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.Models.Level;
import com.example.phys8.Retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PermainanRepository {
    private static PermainanRepository permainanRepository;
    private ApiService apiService;

    //unsend
   // private PermainanRepository(String token){
     //   apiService = ApiService.getInstance(token);
    //}

    //no
    private PermainanRepository(){
           apiService = ApiService.getInstance("");
        }
    //unsend
   // public static PermainanRepository getInstance(String token){
     //   if (permainanRepository == null){
       //     permainanRepository = new PermainanRepository(token);
        //}
       // return permainanRepository;
    //}

    //no
    public static PermainanRepository getInstance(){
           if (permainanRepository == null){
             permainanRepository = new PermainanRepository();
        }
         return permainanRepository;
        }

    public synchronized void resetInstance(){
        if (permainanRepository != null){
            permainanRepository = null;
        }else {
            permainanRepository = null;
        }
    }

    public MutableLiveData<List<GetQuestionWithLevelid.Result>> getQuestionWithLevelId(String levelId){
        final MutableLiveData<List<GetQuestionWithLevelid.Result>> listQuestionWithLevelId = new MutableLiveData<>();

        apiService.getQuestionWithLevelId(levelId).enqueue(new Callback<GetQuestionWithLevelid>() {
            @Override
            public void onResponse(Call<GetQuestionWithLevelid> call, Response<GetQuestionWithLevelid> response) {

                if (response.isSuccessful()){
                        listQuestionWithLevelId.postValue(response.body().getResult());

                }
            }

            @Override
            public void onFailure(Call<GetQuestionWithLevelid> call, Throwable t) {
            }
        });

        return listQuestionWithLevelId;
    }

    public MutableLiveData<List<Level.Result>> getAllLevel(){
        final MutableLiveData<List<Level.Result>> listAllLevel = new MutableLiveData<>();

        apiService.getAllLevel().enqueue(new Callback<Level>() {
            @Override
            public void onResponse(Call<Level> call, Response<Level> response) {

                if (response.isSuccessful()){
                    listAllLevel.postValue(response.body().getResult());
                }
            }
            @Override
            public void onFailure(Call<Level> call, Throwable t) {
            }
        });

        return listAllLevel;
    }
}
