package com.example.sira.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CustomView extends AppCompatActivity {

    MyView myView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);
        /*MyView mv = new MyView(this);
        setContentView(mv);*/
        //MyView를 내부 클래스롤 선언하였을 경우, MyView객체를 setContentView에 설정

        //객체 찾기
        myView = (MyView)findViewById(R.id.myView);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_circle:
                myView.setDraw(true);
                //myView.setColor(Color.LTGRAY);
                myView.invalidate();
                //invalidate : onDraw 재호출
                break;
        }
    }
}
