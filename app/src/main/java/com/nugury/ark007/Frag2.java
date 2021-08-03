package com.nugury.ark007;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class Frag2 extends Fragment {
    private View view;

    TextView dicetext;
    Button dicebutton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag2,container,false);

        dicetext = v.findViewById(R.id.dicenum);
        dicebutton = v.findViewById(R.id.diceroll);

        dicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dicenum = 0;

                Random random = new Random();

                dicenum = random.nextInt(6)+1;

                dicetext.setText(String.valueOf(dicenum));
            }
        });

        return v;
    }
}
