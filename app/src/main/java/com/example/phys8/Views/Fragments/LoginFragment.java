package com.example.phys8.Views.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.R;
import com.example.phys8.ViewModels.LoginViewModel;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    private TextInputLayout til_email_LoginFragment, til_password_LoginFragment;
    private Button btn_submit_LoginFragment;
    private TextView txt_register_LoginFragment;
    private LoginViewModel loginViewModel;
    private SharedPreferenceHelper helper;
    SharedPreferences sharedPreferences;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        sharedPreferences = getActivity().getSharedPreferences("token_account", Context.MODE_PRIVATE);

        if (sharedPreferences.getString("token", null)==null) {
            initial(view);


            txt_register_LoginFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
                }
            });

            loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);
            helper = SharedPreferenceHelper.getInstance(requireActivity());
            btn_submit_LoginFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String email = til_email_LoginFragment.getEditText().getText().toString().trim();
                    String pass = til_password_LoginFragment.getEditText().getText().toString().trim();

                    if (!email.isEmpty()
                            && !pass.isEmpty()) {

                        loginViewModel.login(email, pass).observe(LoginFragment.this.requireActivity(), tokenResponse -> {
                            if (tokenResponse != null) {
                                helper.saveAccessToken(tokenResponse.getAuthorization());

                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("token", tokenResponse.getAuthorization());
                                editor.apply();


                                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_berandaFragment);
                                Toast.makeText(LoginFragment.this.requireActivity(), "Login Success", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginFragment.this.requireActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(LoginFragment.this.requireActivity(), "Insert email and password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_berandaFragment);
        }
    }

    private void initial(View view) {
        til_email_LoginFragment = getActivity().findViewById(R.id.til_email_LoginFragment);
        til_password_LoginFragment = getActivity().findViewById(R.id.til_password_LoginFragment);
        btn_submit_LoginFragment = getActivity().findViewById(R.id.btn_submit_LoginFragment);
        txt_register_LoginFragment = getActivity().findViewById(R.id.txt_register_LoginFragment);

        loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);
    }

}