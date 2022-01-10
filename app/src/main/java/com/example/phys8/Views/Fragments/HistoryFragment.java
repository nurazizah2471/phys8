package com.example.phys8.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.QuizHistory;
import com.example.phys8.R;
import com.example.phys8.ViewModels.QuizHistoryViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    private QuizHistoryViewModel quizHistoryViewModel;
    private SharedPreferenceHelper helper;
    private List <QuizHistory.Result> arrayHistory;
    private List <QuizHistory.Result> arrayRank;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inisialisasi(view);

        //quizHistoryViewModel.init(helper.getAccessToken()); unsend
        quizHistoryViewModel.getQuizHistory(helper.getUserId());
        quizHistoryViewModel.getResultGetQuizHistory().observe(getActivity(), showResultQuizHistory);

        //quizHistoryViewModel.init(helper.getAccessToken()); unsend
        quizHistoryViewModel.getRank();
        quizHistoryViewModel.getResultGetRank().observe(getActivity(), showResultRank);
    }

    private Observer<List<QuizHistory.Result>> showResultQuizHistory = new Observer<List<QuizHistory.Result>>() {
        @Override
        public void onChanged(List<QuizHistory.Result> results) {
            if(results!=null) {
                arrayHistory = results;
            }
        }
    };

    private Observer<List<QuizHistory.Result>> showResultRank = new Observer<List<QuizHistory.Result>>() {
        @Override
        public void onChanged(List<QuizHistory.Result> results) {
            if(results!=null) {
                arrayRank = results;
            }
        }
    };


    private void inisialisasi(View view) {
        quizHistoryViewModel=new ViewModelProvider(getActivity()).get(QuizHistoryViewModel.class);
    }
}