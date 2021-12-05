package com.example.phys8.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.phys8.Repositories.ProfileRepository;


public class ProfileViewModel extends AndroidViewModel {
    private ProfileRepository profileRepository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token){
        profileRepository = ProfileRepository.getInstance(token);
    }

    public LiveData<String> logout(){
        profileRepository.resetInstance();
        return profileRepository.logout();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        profileRepository.resetInstance();
    }
}
