package com.syntaxreborn.gazzzkeun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

//Identitas
//1. Reihan wiyanda - 10119011
//2. Rachman Aldiansyah - 10119038
//3. Diva Sabila Ramadhan - 10119039
//4. Rendy Dermawan- 10119030
//5. Adira Fahri Gathan - 10119025
// IF-1
public class Adapter extends PagerAdapter {
    int[] layouts;
    LayoutInflater layoutInflater;

    public Adapter(Context context, int[] layouts) {
        this.layouts = layouts;
        this.layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(layouts[position], container, false);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}