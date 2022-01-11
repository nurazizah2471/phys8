package com.example.phys8.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.User;
import com.example.phys8.R;
import com.example.phys8.ViewModels.ProfileViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BerandaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BerandaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BerandaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BerandaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BerandaFragment newInstance(String param1, String param2) {
        BerandaFragment fragment = new BerandaFragment();
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
        return inflater.inflate(R.layout.fragment_beranda, container, false);
    }

//    private Button btnPlayGame_berandaFragment;
    private ImageView btnPlayGame_berandaFragment, btn_exit;
    private CardView card_profile;
    private TextView textView12;
    ProfileViewModel profileViewModel;

    private SharedPreferenceHelper helper;
    TextView ticket_amount, cash_amount, coin_amount, name_user;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inisialisasi();
        profileViewModel.init(helper.getAccessToken()); //unsend
        profileViewModel.getUserWithId(helper.getUserId());
        profileViewModel.getResultUserWithId().observe(getActivity(), showResultUserInfo);


//        textView12.setText(helper.getUserId());

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_berandaFragment_to_loginFragment);
            }
        });

        card_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_berandaFragment_to_profileFragment);
            }
        });

        btnPlayGame_berandaFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_berandaFragment_to_pilihLevelFragment);
            }
        });
    }

    private Observer<User.Result> showResultUserInfo = new Observer<User.Result>() {
        @Override
        public void onChanged(User.Result results) {
            if(results.getUsername().length()>5) {
                name_user.setText(String.valueOf(results.getUsername().subSequence(0, 5)+"..."));
            }else {
                name_user.setText(String.valueOf(results.getUsername()));
            }
            cash_amount.setText(String.valueOf(results.getMyuser().getMoney()));
            ticket_amount.setText(String.valueOf(results.getMyuser().getTicket()));
            coin_amount.setText(String.valueOf(results.getMyuser().getScore()));
        }
    };

    private void inisialisasi() {
        ticket_amount = getActivity().findViewById(R.id.ticket_amount);
        cash_amount = getActivity().findViewById(R.id.cash_amount);
        coin_amount = getActivity().findViewById(R.id.coin_amount);
        name_user = getActivity().findViewById(R.id.name_user);
        btn_exit = getActivity().findViewById(R.id.btn_exit);
        card_profile = getActivity().findViewById(R.id.card_profile);
        btnPlayGame_berandaFragment = getActivity().findViewById(R.id.btnPlayGame_berandaFragment);
        profileViewModel=new ViewModelProvider(this).get(ProfileViewModel.class);
//        textView12 = getActivity().findViewById(R.id.textView12);
    }
}