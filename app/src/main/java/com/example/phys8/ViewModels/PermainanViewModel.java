package com.example.phys8.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.GetQuestionWithHistoryId;
import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.Models.Level;
import com.example.phys8.Repositories.AuthRepository;
import com.example.phys8.Repositories.PermainanRepository;

import java.util.List;

public class PermainanViewModel extends AndroidViewModel {
    private PermainanRepository permainanRepository;

    public PermainanViewModel(Application application) {
        super(application);
        //no
        permainanRepository = permainanRepository.getInstance();
    }

    //unsend
    //public void init(String token){

     //   permainanRepository = PermainanRepository.getInstance(token);
   // }


    //== Begin of view model to get question with level id
    private MutableLiveData<List<GetQuestionWithLevelid.Result>> resultQuestionWithLevelId = new MutableLiveData<>();
    public void getQuestionWithLevelId(String levelId){
        resultQuestionWithLevelId = permainanRepository.getQuestionWithLevelId(levelId);
    }
    public LiveData<List<GetQuestionWithLevelid.Result>> getResultQuestionWithLevelId(){return resultQuestionWithLevelId;}

    //== Begin of view model to get all level
    private MutableLiveData<List<Level.Result>> resultAllLevel = new MutableLiveData<>();
    public void getAllLevel(){
        resultAllLevel = permainanRepository.getAllLevel();
    }
    public LiveData<List<Level.Result>> getResultAllLevel(){return resultAllLevel;}

    private MutableLiveData<List<GetQuestionWithHistoryId.Result>> resultQuestionWithHistoryId = new MutableLiveData<>();
    public void getQuestionWithHistoryId(String quizHistoryId){
        resultQuestionWithHistoryId = permainanRepository.getQuestionWithHistoryId(quizHistoryId);
    }
    public LiveData<List<GetQuestionWithHistoryId.Result>> getResultQuestionWithHistoryId(){return resultQuestionWithHistoryId;}
    @Override
    protected void onCleared() {
        super.onCleared();

        permainanRepository.resetInstance();
    }
}
