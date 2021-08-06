package com.nugury.ark007;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Frag4 extends Fragment {
    private View view;

    class Point{
        float x;
        float y;
        boolean check;
        int color;

        public Point(float x, float y, boolean check, int color){
            this.x = x;
            this.y = y;
            this.check = check;
            this.color = color;
        }
    }

    class MyView extends View{
        public MyView(Context context) {super(context);}

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setStrokeWidth(15);
            for(int i=1; i<points.size(); i++){
                p.setColor(points.get(i).color);
                if(!points.get(i).check)
                    continue;
                canvas.drawLine(points.get(i-1).x,points.get(i-1).y,points.get(i).x,points.get(i).y,p);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event){
            float x = event.getX();
            float y = event.getY();

            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    points.add(new Point(x,y,false,color));
                case MotionEvent.ACTION_MOVE:
                    points.add(new Point(x,y,true,color));
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            invalidate();
            return true;
        }
    }

    ArrayList<Point> points = new ArrayList<Point>();
    Button draw_red_btn,draw_blue_btn,draw_black_btn,clearbtn;
    LinearLayout drawlinear;
    int color = Color.BLACK;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag4,container,false);

        final MyView m = new MyView(getContext());
        v.findViewById(R.id.draw_red_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.RED ;
            }
        });
        v.findViewById(R.id.draw_blue_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.BLUE ;
            }
        });
        v.findViewById(R.id.draw_black_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.BLACK ;
            }
        });

        clearbtn = v.findViewById(R.id.clear_btn);
        drawlinear = v.findViewById(R.id.draw_linear);
        clearbtn.setOnClickListener(new View.OnClickListener() { //지우기 버튼 눌렸을때
            @Override
            public void onClick(View v){
                points.clear();
                m.invalidate();
            }
        });
        drawlinear.addView(m);

        //디바이스 회전시 값 유지를 하기위한 코드
//        Resources r = Resources.getSystem();
//        Configuration config = r.getConfiguration();
//        onConfigurationChanged(config);

        return v;
    }

//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        switch(newConfig.orientation){
//            case Configuration.ORIENTATION_LANDSCAPE:
//                Toast.makeText(getContext(),"가로",Toast.LENGTH_SHORT).show();
//                break;
//            case Configuration.ORIENTATION_PORTRAIT:
//                Toast.makeText(getContext(),"세로",Toast.LENGTH_SHORT).show();
//                return;
//        }
//    }
}
