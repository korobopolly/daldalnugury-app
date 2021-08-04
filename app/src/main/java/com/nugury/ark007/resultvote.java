package com.nugury.ark007;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class resultvote extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.resultvote);
        setTitle("투표 결과");

        ImageView resImg = (ImageView) findViewById(R.id.resImg);
        TextView resText = (TextView) findViewById(R.id.resText);
        int top = 0;

        Intent intent = getIntent();
        int[] rVote = intent.getIntArrayExtra("vCount");
        String[] rName = intent.getStringArrayExtra("Name");

        int rImg[] = {R.drawable.facebook,R.drawable.instagram,R.drawable.youtube,R.drawable.spotify,R.drawable.whatsapp,R.drawable.tiktok};

        for(int i = 0; i<rVote.length; i++){
            if(rVote[top]<rVote[i])
                top = i;
        }

        rVote.toString();
        resImg.setImageResource(rImg[top]);
        resText.setText(rName[top]+"/"+rVote[top]+"표");

        Button btn=findViewById(R.id.backBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
