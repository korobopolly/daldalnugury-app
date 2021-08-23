package com.nugury.ark007;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class Frag2 extends Fragment {
    private View view;

    private TextView txtDice;
    private Button btnResult;
    private Button btnReset;
    int count = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag2,container,false);

        txtDice = v.findViewById(R.id.txtDice);
        btnResult = v.findViewById(R.id.btnResult);
        btnReset = v.findViewById(R.id.btnReset);


        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDice.setVisibility(View.VISIBLE);
                Random num = new Random();
                int k = num.nextInt(6)+1;
                Toast.makeText(getContext(), "주사위를 굴렸습니다.", Toast.LENGTH_SHORT).show();
                count++;
                txtDice.setText(String.valueOf(k));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDice.setVisibility(View.GONE);
                Toast.makeText(getContext(), "초기화합니다.", Toast.LENGTH_SHORT).show();
                txtDice.setText("");
                count = 0;
            }
        });

        return v;
    }
}
