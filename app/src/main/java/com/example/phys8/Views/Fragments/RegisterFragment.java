package com.example.phys8.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phys8.Models.Register;
import com.example.phys8.R;
import com.example.phys8.ViewModels.RegisterViewModel;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    private TextView txt_login_RegisterFragment, txt_btn_fragmentRegister;
    private FrameLayout btn_submit_RegisterFragment;
    private TextInputLayout til_name_RegisterFragment, til_email_RegisterFragment,
            til_password_RegisterFragment, till_password_confirmation_RegisterFragment;
    private RegisterViewModel registerViewModel;
    private ProgressBar progressBar;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initial(view);

        txt_login_RegisterFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });

        btn_submit_RegisterFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                txt_btn_fragmentRegister.setText("Silakan tunggu");
                btn_submit_RegisterFragment.setBackground(getResources().getDrawable(R.drawable.bg_btn_red_inloading));
                btn_submit_RegisterFragment.setEnabled(false);

                String name = til_name_RegisterFragment.getEditText().getText().toString().trim();
                String email = til_email_RegisterFragment.getEditText().getText().toString().trim();
                String pass = til_password_RegisterFragment.getEditText().getText().toString().trim();
                String cpass = till_password_confirmation_RegisterFragment.getEditText().getText().toString().trim();

                if (!name.isEmpty()
                        && !email.isEmpty()
                        && !pass.isEmpty()
                        && !cpass.isEmpty()){

                    registerViewModel.register(name, email, pass, cpass).observe(requireActivity(), new Observer<Register>() {
                        @Override
                        public void onChanged(Register registerResponse) {
                            if (registerResponse.getStatus() == "Registrasi berhasil") {
                                btn_submit_RegisterFragment.setEnabled(true);
                                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
                                Toast.makeText(requireActivity(), registerResponse.getStatus(), Toast.LENGTH_SHORT).show();
                            } else{
                                progressBar.setVisibility(View.GONE);
                                txt_btn_fragmentRegister.setText("Daftar");
                                btn_submit_RegisterFragment.setBackground(getResources().getDrawable(R.drawable.bg_btn_red_active));
                                btn_submit_RegisterFragment.setEnabled(true);
                                Toast.makeText(requireActivity(), registerResponse.getStatus(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    progressBar.setVisibility(View.GONE);
                    txt_btn_fragmentRegister.setText("Daftar");
                    btn_submit_RegisterFragment.setBackground(getResources().getDrawable(R.drawable.bg_btn_red_active));
                    btn_submit_RegisterFragment.setEnabled(true);
                    Toast.makeText(requireActivity(), "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initial(View view) {
        txt_login_RegisterFragment = getActivity().findViewById(R.id.txt_login_RegisterFragment);
        btn_submit_RegisterFragment = getActivity().findViewById(R.id.btn_submit_RegisterFragment);
        til_name_RegisterFragment = getActivity().findViewById(R.id.til_name_RegisterFragment);
        til_email_RegisterFragment = getActivity().findViewById(R.id.til_email_RegisterFragment);
        til_password_RegisterFragment = getActivity().findViewById(R.id.til_password_RegisterFragment);
        till_password_confirmation_RegisterFragment = getActivity().findViewById(R.id.til_password_confirmation_RegisterFragment);
        txt_btn_fragmentRegister = view.findViewById(R.id.txt_btn_fragmentRegister);
        progressBar = view.findViewById(R.id.progressBar_FragmentRegister);

        registerViewModel = new ViewModelProvider(getActivity()).get(RegisterViewModel.class);
    }
}