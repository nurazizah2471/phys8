package com.example.phys8.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.Categories;
import com.example.phys8.Models.QuizHistory;
import com.example.phys8.Retrofit.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizHistoryRepository {
    private static QuizHistoryRepository quizHistoryRepository;
    private ApiService apiService;

    private QuizHistoryRepository(String token){
        apiService = ApiService.getInstance(token);
    }

    public static QuizHistoryRepository getInstance(String token){
        if (quizHistoryRepository == null){
            quizHistoryRepository = new QuizHistoryRepository(token);
        }
        return quizHistoryRepository;
    }

    public synchronized void resetInstance(){
        if (quizHistoryRepository != null){
            quizHistoryRepository = null;
        }else {
            quizHistoryRepository = null;
        }
    }

    public MutableLiveData<QuizHistory.Result> addQuizHistory(String student_id){
        final MutableLiveData<QuizHistory.Result> listAddHistory = new MutableLiveData<>();

        apiService.addQuizHistory(student_id).enqueue(new Callback<QuizHistory.Result>() {
            @Override
            public void onResponse(Call<QuizHistory.Result> call, Response<QuizHistory.Result> response) {
                if (response.isSuccessful()){

                    listAddHistory.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<QuizHistory.Result> call, Throwable t) {
            }
        });

        return listAddHistory;
    }

    public MutableLiveData<QuizHistory.Result> addUserAnswer(String quiz_history_id, String question_id, String user_answer){
        final MutableLiveData<QuizHistory.Result> listAddUserAnswer = new MutableLiveData<>();
        System.out.println("masuk sebelum repo");
        apiService.addUserAnswer(quiz_history_id, question_id, user_answer).enqueue(new Callback<QuizHistory.Result>() {
            @Override
            public void onResponse(Call<QuizHistory.Result> call, Response<QuizHistory.Result> response) {
                if (response.isSuccessful()){

                    listAddUserAnswer.postValue(response.body());
                    System.out.println("masuk setelah proses repo");
                }
            }

            @Override
            public void onFailure(Call<QuizHistory.Result> call, Throwable t) {
            }
        });

        return listAddUserAnswer;
    }
}
