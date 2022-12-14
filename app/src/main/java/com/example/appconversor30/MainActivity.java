package com.example.appconversor30;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;

import com.example.appconversor30.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.btnConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,ConversorMonedas.class);
            startActivity(intent);
            }
        });

        mBinding.btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_ButtonSelection.class);
                startActivity(intent);
            }
        });

        mBinding.btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finishAndRemoveTask();

            }
        });
    }
}