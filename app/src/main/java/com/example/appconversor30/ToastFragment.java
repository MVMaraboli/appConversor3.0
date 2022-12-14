package com.example.appconversor30;

import android.content.Intent;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.appconversor30.databinding.FragmentToastBinding;


public class ToastFragment extends Fragment {

    private FragmentToastBinding mBinding;

    public ToastFragment() {
        // Required empty public constructor
    }

    public static ToastFragment newInstance() {
        ToastFragment fragment = new ToastFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentToastBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }
    boolean lbtnGreen = true;
    boolean lbtnRed = true;

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        mBinding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),MainActivity.class);
                getActivity().finish();
                System.exit(0);
                startActivity(intent);
            }
        });

        mBinding.btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lbtnGreen == true) {
                    android.widget.Toast.makeText(getContext(), "Ha activado el botón verde...", Toast.LENGTH_LONG).show();
                    mBinding.btnGreen.setText("Botón Verde Activado!");
                    lbtnGreen = false;
                } else if(lbtnGreen == false) {
                    android.widget.Toast.makeText(getContext(),"El botón verde ha sido desactivado!",Toast.LENGTH_LONG).show();
                    mBinding.btnGreen.setText("Botón Verde");
                    lbtnGreen=true;
                }

            }
        });

        mBinding.btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lbtnRed == true) {
                    android.widget.Toast.makeText(getContext(), "Ha activdo el botón rojo...", Toast.LENGTH_LONG).show();
                    mBinding.btnRed.setText("Botón rojo Activado!");
                    lbtnRed = false;
                } else if(lbtnRed == false) {
                    android.widget.Toast.makeText(getContext(),"El botón rojo ha sido desactivado!",Toast.LENGTH_LONG).show();
                    mBinding.btnRed.setText("Botón rojo");
                    lbtnRed=true;
                }

            }
        });
    }
}