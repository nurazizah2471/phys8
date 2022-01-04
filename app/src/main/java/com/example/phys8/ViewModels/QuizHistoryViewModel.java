package com.example.phys8.ViewModels;

import android.app.Application;
import android.graphics.Movie;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.Models.Level;
import com.example.phys8.Models.QuizHistory;
import com.example.phys8.Repositories.PermainanRepository;
import com.example.phys8.Repositories.QuizHistoryRepository;

import java.util.List;

public class QuizHistoryViewModel extends AndroidViewModel {
    private QuizHistoryRepository quizHistoryRepository;

    public QuizHistoryViewModel(Application application) {
        super(application);
    }

    public void init(String token){

        quizHistoryRepository = QuizHistoryRepository.getInstance(token);
    }

    private MutableLiveData<QuizHistory.Result> resultAddQuizHistory = new MutableLiveData<>();

    public void addQuizHistory(String student_id){
        resultAddQuizHistory = quizHistoryRepository.addQuizHistory(student_id);
    }
    public LiveData<QuizHistory.Result> getResultAddQuizHistory(){
        return resultAddQuizHistory;
    }

    private MutableLiveData<QuizHistory.Result> resultAddUserAnswer = new MutableLiveData<>();

    public void addUserAnswer(String quiz_history_id, String question_id, String user_answer){
        System.out.println("masuk viewmodel");
        resultAddUserAnswer = quizHistoryRepository.addUserAnswer(quiz_history_id, question_id, user_answer);
    }
    public LiveData<QuizHistory.Result> getResultAddUserAnswer(){
        return resultAddUserAnswer;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        quizHistoryRepository.resetInstance();
    }
}
