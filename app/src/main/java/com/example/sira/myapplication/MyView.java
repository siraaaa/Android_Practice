package com.example.sira.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private boolean isDraw = false;
    private int color = Color.BLUE;

    //view 상속 -> 생성자 3개 추가
    public MyView(Context context) { //기본 생성자 - 필수★
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDraw(boolean draw) { //외부에서 바꿀 수 있도록 setter 넘겨준다
        isDraw = draw;
    }

    public void setColor(int color) {
        this.color = color;
    }

    //뷰가 화면에 그려져야 할 때 호출(그리기 메소드)
    @Override
    protected void onDraw(Canvas canvas) {
        //canvas ; 그림이 그려지는 영역
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);

        //Paint : 그림을 그리는 도구
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        if(isDraw) //원이 없을 때 실행
            canvas.drawCircle(100,100,80,paint); //x좌표, y좌표, 반지름
    }
}
