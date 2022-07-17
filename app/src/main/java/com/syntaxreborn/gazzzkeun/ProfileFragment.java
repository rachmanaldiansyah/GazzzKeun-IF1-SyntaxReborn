package com.syntaxreborn.gazzzkeun;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;
//Reihan
public class ProfileFragment extends Fragment {
    ViewFlipper viewFlipper;
    FragmentManager fragmentManager;
    int images[] = {
            R.drawable.mancung,
            R.drawable.rachman,
            R.drawable.edit1,
            R.drawable.edit2,
            R.drawable.edit3
            //Lamun erek ganti fotona asupkeun heula di @drawable copas bae ke rename taro di edit1-3
            //contoh mancung
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        viewFlipper = (ViewFlipper)rootView.findViewById(R.id.slider);
        for(int i=0; i<images.length; i++){
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage(images[i]);
        }
        return rootView;
    }

    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res+"");
        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);


    }
}