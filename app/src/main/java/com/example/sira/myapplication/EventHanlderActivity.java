package com.example.sira.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EventHanlderActivity extends AppCompatActivity {
    private Button button;
    //멤버변수로 선언 : 다른 곳에서도 사용 가능
    MyClick myClick = new MyClick(); //멤버변수 만들어서 버튼과 연결

    MyLongClick myLongClick = new MyLongClick();
    LinearLayout layout;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        button = (Button)findViewById(R.id.btn_click); //버튼 타입 캐스트
        button.setOnClickListener(myClick); //이벤트 핸들러-버튼과 연결

        layout = (LinearLayout)findViewById(R.id.mainLayout);
        layout.setOnTouchListener(new View.OnTouchListener(){ //boolean타입 반환값 true이면 한번 실행되고 더이상 실행 x
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                layout.setBackgroundColor(Color.BLUE);
                return false;//터치 이후에도 이 이벤트를 받아들임
            }
        });

        button2 = (Button)findViewById(R.id.btn_longClick);
        button2.setOnLongClickListener(myLongClick);

        button3 = (Button)findViewById(R.id.btn_click3);
        button3.setOnClickListener(myClick2);

        button4 = (Button)findViewById(R.id.btn_click4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(EventHanlderActivity.this, "onClick method 4", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 이벤트 핸들러 : 클래스 객체 형태로 만들어서 버튼과 연결
    // View가 가지고 있는 내부 인터페이스를 통해 메소스 구현 (인터페이스가 가지고 있는 메소드는 반드시 정의)
    class MyClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(EventHanlderActivity.this, "onClick method", Toast.LENGTH_SHORT).show();
        }
    }

    class MyLongClick implements View.OnLongClickListener{
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(EventHanlderActivity.this, "onLongClick method", Toast.LENGTH_SHORT).show();
            return true; //여기서 처리를 끝내버리니까 반환값 true
        }
    }

    View.OnClickListener myClick2 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(EventHanlderActivity.this, "onClick method 2", Toast.LENGTH_SHORT).show();
        }
    };
    //인터페이스에서 직접 객체를 만드는 방식 - 세미콜론 주의
}
