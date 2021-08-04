package com.nugury.ark007;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag4 extends Fragment {
    private View view;

    Button btn;
    int vCount[] = new int[6];
    ImageView[] imgV = new ImageView[6];
    int[] imgID = {R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img6};
    String Name[] = {"페이스북","인스타그램","유튜브","스포티파이","왓츠앱","틱톡"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag4,container,false);

        btn = v.findViewById(R.id.votebtn);

        for (int i = 0; i<imgID.length; i++){
            final int index;
            index = i;
            imgV[index] = v.findViewById(imgID[index]);
            imgV[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vCount[index]++;
                    Toast.makeText(getContext(),Name[index]+"에게 투표하였습니다.",Toast.LENGTH_SHORT).show();
                }
            });
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),resultvote.class);
                intent.putExtra("vCount",vCount);
                intent.putExtra("Name",Name);
                getActivity().startActivity(intent);
            }
        });

        return v;
    }
}
