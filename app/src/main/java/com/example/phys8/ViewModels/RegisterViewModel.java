package com.example.phys8.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.Register;
import com.example.phys8.Repositories.AuthRepository;


public class RegisterViewModel extends AndroidViewModel {
    private AuthRepository authRepository;
    public RegisterViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getInstance();
    }

    public MutableLiveData<Register> register(String name, String email, String password, String password_confirmation){
        return authRepository.register(name, email, password, password_confirmation);
    }

}
