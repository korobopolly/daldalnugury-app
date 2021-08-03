package com.nugury.ark007;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class Frag3 extends Fragment {
    private View view;

    ImageView taeligif;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag3,container,false);

        taeligif = v.findViewById(R.id.gifimage);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(taeligif);
        Glide.with(getContext()).load(R.drawable.yes).into(gifImage);

        return v;
    }
}
