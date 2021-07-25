package com.nugury.ark007;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    private View view;

    ImageView taeli;

    Button alpha;
    Button rotation;
    Button visibility;
    Button back;

    float transparency = 1;
    float degree = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag1, container, false);

        taeli = v.findViewById(R.id.taeli);

        alpha = v.findViewById(R.id.alpha);
        rotation = v.findViewById(R.id.rotation);
        visibility = v.findViewById(R.id.visibility);
        back = v.findViewById(R.id.back);

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transparency -= 0.1;
                taeli.setAlpha((float) transparency);
            }
        });

        rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degree += 90;
                taeli.setRotation((float) degree);
            }
        });

        visibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taeli.setVisibility(View.INVISIBLE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taeli.setAlpha((float) 1);
                transparency = 1;
                taeli.setRotation((float) 0);
                degree = 0;
                taeli.setVisibility(View.VISIBLE);
            }
        });


        return v;
    }
}
