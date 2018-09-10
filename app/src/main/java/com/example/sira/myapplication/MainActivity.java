package com.example.sira.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                Toast.makeText(this, "Sira and Dongju", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn2:
                Intent intent = new Intent(this, CalculatorActivity.class); //서브 액티비티와 연결
                startActivity(intent);
                break;
        }
    }
}
