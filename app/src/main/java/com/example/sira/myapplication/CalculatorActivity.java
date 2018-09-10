package com.example.sira.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CalculatorActivity extends AppCompatActivity { //액티비티를 상속받는다, onCreate 메소드는 반드시 구현해주어야 함

    // alt + insert -> override method 추가

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator); //서브 레이아웃과 연결
    }

    public void onClick(View v){

    }
}
