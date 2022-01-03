package com.example.phys8.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.R;

import java.util.ArrayList;
import java.util.List;

public class rvAdapter_ikonBenarSalahKuis extends RecyclerView.Adapter<rvAdapter_ikonBenarSalahKuis.ikonBenarSalahKuisHolder>{
    private Context context;
    private int idUser;
    boolean isStarted;
    private List<GetQuestionWithLevelid.Result> listQuestion; //sudah disesuaikan dengan level yang diinginkan

    public void setListQuestionUserAdapter(List<GetQuestionWithLevelid.Result> listQuestion, int idUser) {
        this.listQuestion = listQuestion;
        this.idUser = idUser;
    }

    public rvAdapter_ikonBenarSalahKuis(Context context) {
        this.context = context;
        this.listQuestion=new ArrayList<>();
    }

    public List<GetQuestionWithLevelid.Result> getListQuestion(){
        return listQuestion;
    }

    public int getIdUser(){
        return idUser;
    }

    @Override
    public ikonBenarSalahKuisHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_ikon_benar_salah_kuis, parent, false);
        return new ikonBenarSalahKuisHolder(view);
    }

    @Override
    public void onBindViewHolder(rvAdapter_ikonBenarSalahKuis.ikonBenarSalahKuisHolder holder, int position) {
        holder.ikon_benar_salah_kuis.setImageResource(R.drawable.ic_belumjawabkuis);


                //untukpembahsan
       // String correctAnswer;

        //if(!resultListQuestion.getHistory().isEmpty()) {
         //   final List<Question.Result.History> resultListHistoryFromQuestion = resultListQuestion.getHistory();
          //  for (int i = 0; i < resultListHistoryFromQuestion.size(); i++) {
            //    if (resultListHistoryFromQuestion.get(i).getStudent_id() == getIdUser()) {
              //      final Question.Result.History.Pivot resultPivotHistoryWithQuestion = resultListHistoryFromQuestion.get(i).getPivot();

                //    if(!resultPivotHistoryWithQuestion.getUser_answer().isEmpty()){
                  //      if(!resultListQuestion.getAnswer_option_text().isEmpty()){
                    //        for(int j=0;j<resultListQuestion.getAnswer_option_text().size();j++){
                      //          if(resultListQuestion.getAnswer_option_text().get(j).getPivot().getIs_correct_answer().equals("1")){
                        //            correctAnswer = resultListQuestion.getAnswer_option_text().get(j).getAnswer_option_text();
                          //      }
                            //}
                        //}
                        //if(resultListQuestion.getIs_image_answer().toString().equals("1")){
                            //for(int j=0;j<resultListQuestion.getQuestion_answer_image().size();j++){
                          //      if(resultListQuestion.getQuestion_answer_image().get(j).getPivot().getIs_correct_answer().equals("1")){
                        //           correctAnswer = resultListQuestion.getQuestion_answer_image().get(j).getImage();
                      //          }
                    //        }
                  //      }
                //    }else{
              //          holder.
            //        }


          //      }
        //    }

      //  }
    }

    @Override
    public int getItemCount() {
        return getListQuestion().size();
    }

    public class ikonBenarSalahKuisHolder extends RecyclerView.ViewHolder {
        ImageView ikon_benar_salah_kuis;
        public ikonBenarSalahKuisHolder(View itemView) {
            super(itemView);

            ikon_benar_salah_kuis = itemView.findViewById(R.id.ikon_benar_salah_kuis);
        }
    }
}
