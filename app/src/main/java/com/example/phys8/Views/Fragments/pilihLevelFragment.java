package com.example.phys8.Views.Fragments;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.phys8.Adapters.rvAdapter_level;
import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.Level;
import com.example.phys8.R;
import com.example.phys8.ViewModels.PermainanViewModel;

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
    private SharedPreferenceHelper helper;
    private int numberOfColumns;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inisialisasi();


        permainanViewModel.init(helper.getAccessToken());
        permainanViewModel.getAllLevel();
        permainanViewModel.getResultAllLevel().observe(getActivity(), showResultLevel);


    }

    private void inisialisasi() {
        rv_level_pilihLevelFragment=getActivity().findViewById(R.id.rv_level_pilihLevelFragment);
        keteranganLevel_levelFragment = getActivity().findViewById(R.id.keteranganLevel_levelFragment);
        numberOfColumns = 5;

        permainanViewModel=new ViewModelProvider(getActivity()).get(PermainanViewModel.class);
    }
    private void setRV_level(List<Level.Result> levels) {
        if(levels.size()>0) {
            keteranganLevel_levelFragment.setVisibility(View.GONE);
            rv_level_pilihLevelFragment.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
            adapter_level = new rvAdapter_level(getActivity());
            adapter_level.setListLevelAdapter(levels);
            rv_level_pilihLevelFragment.setAdapter(adapter_level);
        }else{
            keteranganLevel_levelFragment.setVisibility(View.VISIBLE);
            rv_level_pilihLevelFragment.setVisibility(View.GONE);
        }
    }

    private Observer<List<Level.Result>> showResultLevel = new Observer<List<Level.Result>>() {
        @Override
        public void onChanged(List<Level.Result> results) {
            setRV_level(results);
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}