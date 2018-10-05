package com.anhttvn.demostudy.customcalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anhttvn.demostudy.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CustomViewPager extends PagerAdapter {
    private Context mContext;
    public CustomViewPager(Context context){
        mContext = context;
    }
    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.view_custom_calendar, container, false);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);

    }
}
