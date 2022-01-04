package com.example.phys8.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Retrofit.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    private static ProfileRepository profileRepository;
    private ApiService apiService;

//unsend
  //  private ProfileRepository(String token){

    //    apiService = ApiService.getInstance(token);
    //}

    //public static ProfileRepository getInstance(String token){
      //  if (profileRepository == null){
        //    profileRepository = new ProfileRepository(token);
        //}

        //return profileRepository;
    //}

    //no
    private ProfileRepository(){

            apiService = ApiService.getInstance("");
        }
    public static ProfileRepository getInstance(){
          if (profileRepository == null){
            profileRepository = new ProfileRepository();
        }

        return profileRepository;
        }

    public synchronized void resetInstance(){
        if (profileRepository != null){
            profileRepository = null;
        }
    }

    //<String> karna di postman jika berhasil logout akan tampil message atau pesan logout berhasil
    //Cara mengambil response gson berupa String object
    public LiveData<String> logout(){
        MutableLiveData<String> message = new MutableLiveData<>();

        apiService.logout().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String msg = object.getString("message");
                            message.postValue(msg);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });

        return message;
    }
}
