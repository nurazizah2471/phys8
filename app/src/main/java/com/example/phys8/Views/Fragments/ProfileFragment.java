package com.example.phys8.Views.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.User;
import com.example.phys8.R;
import com.example.phys8.ViewModels.ProfileViewModel;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    private ImageView btn_logout_ProfileFragment;
    private ProfileViewModel profileViewModel;
    private SharedPreferenceHelper helper;
    private ImageView btn_profile_peringkat, btn_profile_history;
    private TextView txt_stats_ticket, txt_stats_coin, txt_stats_cash, txt_profile_nama;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initial();

        profileViewModel.init(helper.getAccessToken());// unsend
        profileViewModel.getUserWithId2(helper.getUserId());
        profileViewModel.getResultUserWithId2().observe(getActivity(), showResultUserInfo2);


        btn_profile_peringkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_profileFragment_to_peringkatFragment);
            }
        });

        btn_profile_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_profileFragment_to_historyFragment);
            }
        });

        btn_logout_ProfileFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {

           //     Navigation.findNavController(view1).navigate(R.id.action_profileFragment_to_berandaFragment);

//                profileViewModel.logout().observe(requireActivity(), new Observer<String>() {
//                    @Override
//                    public void onChanged(String s) {

//                        helper.clearPref();

//                        Toast.makeText(requireActivity(), s, Toast.LENGTH_SHORT).show();

                    }
//                });

//        }
        });
    }

    private Observer<User.Result> showResultUserInfo2 = new Observer<User.Result>() {
        @Override
        public void onChanged(User.Result results) {
            if(results.getUsername().length()>10) {
                txt_profile_nama.setText(String.valueOf(results.getUsername().subSequence(0, 10)+"..."));
            }else {
                txt_profile_nama.setText(String.valueOf(results.getUsername()));
            }
            txt_stats_cash.setText(String.valueOf(results.getMyuser().getMoney()));
            txt_stats_ticket.setText(String.valueOf(results.getMyuser().getTicket()));
            txt_stats_coin.setText(String.valueOf(results.getMyuser().getScore()));
        }
    };
    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }

    private void initial() {
        btn_logout_ProfileFragment = getActivity().findViewById(R.id.btn_logout_ProfileFragment);
        btn_profile_peringkat = getActivity().findViewById(R.id.btn_profile_peringkat);
        btn_profile_history = getActivity().findViewById(R.id.btn_profile_history);
        txt_stats_cash = getActivity().findViewById(R.id.txt_stats_cash);
        txt_stats_coin = getActivity().findViewById(R.id.txt_stats_coin);
        txt_stats_ticket = getActivity().findViewById(R.id.txt_stats_ticket);
        txt_profile_nama = getActivity().findViewById(R.id.txt_profile_nama);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        profileViewModel = new ViewModelProvider(getActivity()).get(ProfileViewModel.class);

    }
}