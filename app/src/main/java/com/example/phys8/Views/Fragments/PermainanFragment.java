package com.example.phys8.Views.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phys8.Adapters.rvAdapter_pilgan;
import com.example.phys8.Helpers.ItemClickSupport;
import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.Models.QuizHistory;
import com.example.phys8.R;
import com.example.phys8.ViewModels.PermainanViewModel;
import com.example.phys8.ViewModels.QuizHistoryViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PermainanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PermainanFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PermainanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PermainanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PermainanFragment newInstance(String param1, String param2) {
        PermainanFragment fragment = new PermainanFragment();
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
        return inflater.inflate(R.layout.fragment_permainan, container, false);
    }

    private RecyclerView rv_IkonBenarSalah_FragmentPermainan, rv_PilihanGanda_FragmentPermainan;
    private TextView soal_FragmentPermainan, timer_permainanFragment;
    private TextInputLayout teksInput_FragmentPermainan;
    private PermainanViewModel permainanViewModel;
    private SharedPreferenceHelper helper;
    private List<GetQuestionWithLevelid.Result> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private GetQuestionWithLevelid.Result currentQuestion;
    private rvAdapter_pilgan AdapterPilgan;
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private View myv;
    private QuizHistoryViewModel quizHistoryViewModel;

    private int score, positionChoosenPilgan;
    private boolean answered;
   // private rvAdapter_ikonBenarSalahKuis adapter_ikonBenarSalahKuis;
    private String levelId, quizHistoryId;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inisialisasi(view);
        myv = view;

        addItemClickSupport();

        levelId=getArguments().getString("levelId");
        quizHistoryId=getArguments().getString("quizHistoryId");

        //permainanViewModel.init(helper.getAccessToken()); //unsend
        permainanViewModel.getQuestionWithLevelId(levelId);
        permainanViewModel.getResultQuestionWithLevelId().observe(getActivity(), showQuestion);
    }

    private void addItemClickSupport(){
        ItemClickSupport.addTo(rv_PilihanGanda_FragmentPermainan).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                positionChoosenPilgan = position;
                //quizHistoryViewModel.init(helper.getAccessToken()); unsend
                System.out.println("quizhstry"+quizHistoryId);
                quizHistoryViewModel.addUserAnswer(quizHistoryId, String.valueOf(questionList.get(questionCounter).getId()),
                        questionList.get(questionCounter).getAnswer_option().get(position).getPivot().getOption());
                quizHistoryViewModel.getResultAddUserAnswer().observe(getActivity(), showResultAddUserAnswer);

                checkAnswer(position);
            }
        });
    }

    private void checkAnswer(int position) {
        answered = true;

        countDownTimer.cancel();

        if(questionList.get(questionCounter).getAnswer_option().get(position).getPivot().getOption().equalsIgnoreCase(questionList.get(questionCounter).getCorrect_answer_option())){
            score++;
            Toast.makeText(getActivity(),"Jawaban Benar! Akumulasi skor: "+score, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"Jawaban Salah! Jawaban Benar: "+questionList.get(questionCounter).getCorrect_answer_option()+" Akumulasi skor: "+score, Toast.LENGTH_SHORT).show();
        }
        showSolution();
        showNextQuestion();
    }

    private Observer<List<GetQuestionWithLevelid.Result>> showQuestion = new Observer<List<GetQuestionWithLevelid.Result>>() {
        @Override
        public void onChanged(List<GetQuestionWithLevelid.Result> results) {
            questionList = results;
            questionCountTotal = questionList.size();
            showNextQuestion();

            // setRv_IkonBenarSalah(results);
        }
    };

    private Observer<QuizHistory.Result> showResultAddUserAnswer = new Observer<QuizHistory.Result>() {
        @Override
        public void onChanged(QuizHistory.Result results) {

        }
    };

    private void showNextQuestion() {
        if(levelId.equalsIgnoreCase("1")){
            teksInput_FragmentPermainan.setVisibility(View.GONE);
            rv_PilihanGanda_FragmentPermainan.setVisibility(View.VISIBLE);
        }

        if(questionCounter < questionCountTotal){
            currentQuestion = questionList.get(questionCounter);
            soal_FragmentPermainan.setText(currentQuestion.getQuestion_text());
            setRv_pilgan(currentQuestion.getAnswer_option());

            answered = false;
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        }else{
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                questionCounter++;
                showNextQuestion();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis/1000)/60;
        int seconds = (int) (timeLeftInMillis/1000)%60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timer_permainanFragment.setText(timeFormatted);

        if(timeLeftInMillis<10000){
            timer_permainanFragment.setTextColor(getResources().getColor(R.color.white));
        } else{
            timer_permainanFragment.setTextColor(getResources().getColor(R.color.black));
        }
    }

    private void finishQuiz() {
        //sethighscore
        Navigation.findNavController(myv).navigate(R.id.action_permainanFragment_to_pilihLevelFragment);
        Toast.makeText(getActivity(),"Permainan berakhir. Akumulasi skor: "+score, Toast.LENGTH_SHORT).show();
    }

  //  private void setRv_IkonBenarSalah(List<GetQuestionWithLevelid.Result> questions){
    //    rv_IkonBenarSalah_FragmentPermainan.setLayoutManager(new GridLayoutManager(getContext(), questions.size()));
      //  adapter_ikonBenarSalahKuis = new rvAdapter_ikonBenarSalahKuis(getActivity());
       // adapter_ikonBenarSalahKuis.setListQuestionUserAdapter(questions, help);
        //rv_IkonBenarSalah_FragmentPermainan.setAdapter(adapter_ikonBenarSalahKuis);
    //}
    private void setRv_pilgan(List<GetQuestionWithLevelid.Result.AnswerOption> answerOptionsList){
          rv_PilihanGanda_FragmentPermainan.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
          AdapterPilgan = new rvAdapter_pilgan(getActivity());
          AdapterPilgan.setListPilganAdapter(answerOptionsList);
          rv_PilihanGanda_FragmentPermainan.setAdapter(AdapterPilgan);
    }

    private void inisialisasi(View view) {
      //  rv_IkonBenarSalah_FragmentPermainan = view.findViewById(R.id.rv_IkonBenarSalah_FragmentPermainan);
        timer_permainanFragment = view.findViewById(R.id.timer_permainanFragment);
        rv_PilihanGanda_FragmentPermainan = view.findViewById(R.id.rv_PilihanGanda_FragmentPermainan);
        soal_FragmentPermainan = view.findViewById(R.id.soal_FragmentPermainan);
        teksInput_FragmentPermainan = view.findViewById(R.id.teksInput_FragmentPermainan);

        permainanViewModel=new ViewModelProvider(getActivity()).get(PermainanViewModel.class);
        quizHistoryViewModel=new ViewModelProvider(getActivity()).get(QuizHistoryViewModel.class);
    }

    private void showSolution() {

        questionCounter++;
      }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
}