package com.example.appconversor30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.appconversor30.databinding.ActivityButtonSelectionBinding;

public class Activity_ButtonSelection extends AppCompatActivity {

    private ActivityButtonSelectionBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityButtonSelectionBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        addButtonFragment();
    }
    private void addButtonFragment(){
        ToastFragment toastFragment = new ToastFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(mBinding.containerToast.getId(),toastFragment,ToastFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}