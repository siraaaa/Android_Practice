package com.example.sira.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity { //액티비티를 상속받는다, onCreate 메소드는 반드시 구현해주어야 함

    // alt + insert -> override method 추가

    private EditText etDisplay;
    private int firstNum;
    private int secondNum;
    private String operator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator); //서브 레이아웃과 연결

        etDisplay = (EditText)findViewById(R.id.etDisplay);
        //setContentView 딱 한번만 실행되므로 한번만 찾게 하려면 setContent 아래에 선언
    }

    public void onNumClick(View v){
        String tmp = etDisplay.getText().toString();

        switch (v.getId()) {
            case R.id.btn0:
                tmp += "0"; //EditText에 숫자 이어서 출력
                break;
            case R.id.btn1:
                tmp += "1";
                break;
            case R.id.btn2:
                tmp += "2";
                break;
            case R.id.btn3:
                tmp += "3";
                break;
            case R.id.btn4:
                tmp += "4";
                break;
            case R.id.btn5:
                tmp += "5";
                break;
            case R.id.btn6:
                tmp += "6";
                break;
            case R.id.btn7:
                tmp += "7";
                break;
            case R.id.btn8:
                tmp += "8";
                break;
            case R.id.btn9:
                tmp += "9";
                break;
        }

        etDisplay.setText(tmp);
    }

    public void onOpClick(View v){
        firstNum = Integer.parseInt(etDisplay.getText().toString());

        switch (v.getId()){
            case R.id.btnAddition:
                operator = "+";
                //etDisplay.setText(firstNum + "+");
                break;
            case R.id.btnSubtraction:
                operator = "-";
                //etDisplay.setText(firstNum + "-");
                break;
            case R.id.btnMultiple:
                operator = "*";
                //etDisplay.setText(firstNum + "*");
                break;
            case R.id.btnDivision:
                operator = "/";
                //etDisplay.setText(firstNum + "/");
                break;
        }

        etDisplay.setText("");

    }

    public void onEqualClick(View v){
        int result = 0;
        secondNum = Integer.parseInt(etDisplay.getText().toString()); // String to int

       if(operator.equals("+")){
           result = firstNum + secondNum;
       }
       else if(operator.equals("-")){
           result = firstNum - secondNum;
       }
       else if(operator.equals("/")){
           result = firstNum / secondNum;
       }
       else if(operator.equals("*")){
           result = firstNum * secondNum;
       }
       else{
           Toast.makeText(this, "Please reclick", Toast.LENGTH_SHORT).show();
       }

       etDisplay.setText(Integer.valueOf(result).toString());

    }

    public void onResetClick(View v){
        switch (v.getId()){
            case R.id.btnReset:
                etDisplay.setText(""); //초기화 띄어쓰기 x (띄어쓰기는 아스키코드 13번)
                break;
        }
    }


}
