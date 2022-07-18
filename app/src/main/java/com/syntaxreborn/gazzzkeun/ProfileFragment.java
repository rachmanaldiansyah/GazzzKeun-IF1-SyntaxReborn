package com.syntaxreborn.gazzzkeun;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
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

        Button mancung = (Button)rootView.findViewById(R.id.btn_10119011);
        mancung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mancung();
            }
        });

        Button adira = (Button)rootView.findViewById(R.id.btn_10119025);
        adira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adira();
            }
        });

        Button rendy = (Button)rootView.findViewById(R.id.btn_10119030);
        rendy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rendy();
            }
        });

        Button rahman = (Button)rootView.findViewById(R.id.btn_10119038);
        rahman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rahman();
            }
        });

        Button diva = (Button)rootView.findViewById(R.id.btn_10119039);
        diva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diva();
            }
        });
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
        viewFlipper.setFlipInterval(3500);
        viewFlipper.setAutoStart(true);

    }

    //Alihkan ke sosmed
    private void mancung()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/mancungxyz/"));
        startActivity(intent);
    }

    private void rahman()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/rachman2108/"));
        startActivity(intent);
    }

    private void rendy()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/rendy_dermawan2961/"));
        startActivity(intent);
    }

    private void diva()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/divaramadhan46/"));
        startActivity(intent);
    }

    private void adira()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/adhirafgathan_/"));
        startActivity(intent);
    }
//LoveUStackoverflow
}