package com.example.phys8.Views.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.phys8.Adapters.rvAdapter_ikonBenarSalahKuis;
import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.R;
import com.example.phys8.ViewModels.PermainanViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

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
    private TextView soal_FragmentPermainan;
    private TextInputLayout teksInput_FragmentPermainan;
    private PermainanViewModel permainanViewModel;
    private SharedPreferenceHelper helper;
   // private rvAdapter_ikonBenarSalahKuis adapter_ikonBenarSalahKuis;
    private String levelId;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inisialisasi(view);

        levelId=getArguments().getString("levelId");

        permainanViewModel.init(helper.getAccessToken());
        permainanViewModel.getQuestionWithLevelId(levelId);
        permainanViewModel.getResultQuestionWithLevelId().observe(getActivity(), showQuestion);

    }
    private Observer<List<GetQuestionWithLevelid.Result>> showQuestion = new Observer<List<GetQuestionWithLevelid.Result>>() {
        @Override
        public void onChanged(List<GetQuestionWithLevelid.Result> results) {
               // setRv_IkonBenarSalah(results);
        }
    };

  //  private void setRv_IkonBenarSalah(List<GetQuestionWithLevelid.Result> questions){
    //    rv_IkonBenarSalah_FragmentPermainan.setLayoutManager(new GridLayoutManager(getContext(), questions.size()));
      //  adapter_ikonBenarSalahKuis = new rvAdapter_ikonBenarSalahKuis(getActivity());
       // adapter_ikonBenarSalahKuis.setListQuestionUserAdapter(questions, help);
        //rv_IkonBenarSalah_FragmentPermainan.setAdapter(adapter_ikonBenarSalahKuis);
    //}

    private void inisialisasi(View view) {
      //  rv_IkonBenarSalah_FragmentPermainan = view.findViewById(R.id.rv_IkonBenarSalah_FragmentPermainan);
        //rv_PilihanGanda_FragmentPermainan = view.findViewById(R.id.rv_PilihanGanda_FragmentPermainan);
        //soal_FragmentPermainan = view.findViewById(R.id.soal_FragmentPermainan);
        //teksInput_FragmentPermainan = view.findViewById(R.id.teksInput_FragmentPermainan);

        permainanViewModel=new ViewModelProvider(getActivity()).get(PermainanViewModel.class);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}