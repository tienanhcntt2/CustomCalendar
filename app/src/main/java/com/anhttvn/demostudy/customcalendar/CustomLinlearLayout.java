package com.anhttvn.demostudy.customcalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.anhttvn.demostudy.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CustomLinlearLayout extends LinearLayout {

    private GridView mGridviewAdapter;
    private int month, year;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM yyyy");
    private Calendar mCalendar = Calendar.getInstance(Locale.ENGLISH);
    private Context context;
    private CalendarAdapter mAdapter;
    public CustomLinlearLayout(Context context) {
        super(context);
    }
    public CustomLinlearLayout(Context context, AttributeSet attributeSet){
        super(context);
        this.context = context;
        initLayout();
        adapterCalendar();
    }
    private void initLayout(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendar_layout,this);
        mGridviewAdapter = (GridView) view.findViewById(R.id.canlendar_git);


    }
    private void adapterCalendar(){
        List<Date> dayValue = new ArrayList<Date>();
        Calendar calendar = (Calendar) mCalendar.clone();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int dayFistMDayMonth = calendar.get(Calendar.DAY_OF_WEEK)-1;
        calendar.add(Calendar.DAY_OF_MONTH, -dayFistMDayMonth);
        while (dayValue.size() <33 ){
            dayValue.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
        mAdapter = new CalendarAdapter(context,dayValue,mCalendar);
        mGridviewAdapter.setAdapter(mAdapter);
    }
}
