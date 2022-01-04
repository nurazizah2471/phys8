package com.example.phys8.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phys8.Adapters.rvAdapter_level;
import com.example.phys8.Helpers.ItemClickSupport;
import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.Level;
import com.example.phys8.Models.QuizHistory;
import com.example.phys8.R;
import com.example.phys8.ViewModels.PermainanViewModel;
import com.example.phys8.ViewModels.QuizHistoryViewModel;

import java.util.List;
import java.util.ListIterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link pilihLevelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pilihLevelFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public pilihLevelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pilihLevelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static pilihLevelFragment newInstance(String param1, String param2) {
        pilihLevelFragment fragment = new pilihLevelFragment();
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
        return inflater.inflate(R.layout.fragment_pilih_level, container, false);
    }

    private RecyclerView rv_level_pilihLevelFragment;
    private rvAdapter_level adapter_level;
    private TextView keteranganLevel_levelFragment;
    private PermainanViewModel permainanViewModel;
    private QuizHistoryViewModel quizHistoryViewModel;
    private SharedPreferenceHelper helper;
    private int numberOfColumns;
    private int bundleLevelId;
    private View myv;
    private Bundle bundle;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inisialisasi(view);
        addItemClickSupport();


        keteranganLevel_levelFragment.setText("Sedang menapilkan level...");
        //permainanViewModel.init(helper.getAccessToken()); unsend
        permainanViewModel.getAllLevel();
        permainanViewModel.getResultAllLevel().observe(getActivity(), showResultLevel);


    }

    private void inisialisasi(View view) {
        rv_level_pilihLevelFragment=getActivity().findViewById(R.id.rv_level_pilihLevelFragment);
        keteranganLevel_levelFragment = getActivity().findViewById(R.id.keteranganLevel_levelFragment);
        numberOfColumns = 5;
        myv = view;

        permainanViewModel=new ViewModelProvider(getActivity()).get(PermainanViewModel.class);
        quizHistoryViewModel=new ViewModelProvider(getActivity()).get(QuizHistoryViewModel.class);
    }
    private void setRV_level(List<Level.Result> levels) {
        if(levels.size()>0) {
            keteranganLevel_levelFragment.setVisibility(View.GONE);
            rv_level_pilihLevelFragment.setLayoutManager(new GridLayoutManager(getContext(), levels.size()));
            adapter_level = new rvAdapter_level(getActivity());
            adapter_level.setListLevelAdapter(levels);
            rv_level_pilihLevelFragment.setAdapter(adapter_level);
        }else{
            keteranganLevel_levelFragment.setVisibility(View.VISIBLE);
            keteranganLevel_levelFragment.setText("Level belum tersedia");
            rv_level_pilihLevelFragment.setVisibility(View.GONE);
        }
    }

    private Observer<List<Level.Result>> showResultLevel = new Observer<List<Level.Result>>() {
        @Override
        public void onChanged(List<Level.Result> results) {
            setRV_level(results);
        }
    };

    private Observer<QuizHistory.Result> showResultAddQuizHistory = new Observer<QuizHistory.Result>() {
        @Override
        public void onChanged(QuizHistory.Result results) {
           System.out.println("Hi"+results);
            if(results!=null){
                bundle=new Bundle();
                bundle.putString("levelId", ""+ bundleLevelId);
                bundle.putString("quizHistoryId", ""+ results.getId());

                Navigation.findNavController(myv).navigate(R.id.action_pilihLevelFragment_to_permainanFragment,bundle);
            }else{
                Toast.makeText(getActivity(), "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void addItemClickSupport(){
        ItemClickSupport.addTo(rv_level_pilihLevelFragment).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                bundleLevelId = adapter_level.getListLevel().get(position).getId();

               // quizHistoryViewModel.init(helper.getAccessToken()); unsend
                quizHistoryViewModel.addQuizHistory(helper.getUserId());
                quizHistoryViewModel.getResultAddQuizHistory().observe(getActivity(), showResultAddQuizHistory);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}