package com.anhttvn.demostudy.customcalendar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.anhttvn.demostudy.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CalendarAdapter extends ArrayAdapter {

    private Context mContext;
    private LayoutInflater mInterFace;
    private List<Date> mList;
    private Calendar mCalendar;
    public CalendarAdapter(Context context, List<Date> listDate, Calendar calendar) {
        super(context,R.layout.item_calendar);

        mContext = context;
        mList = listDate;
        mCalendar = calendar;
        mInterFace = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Date mDate = mList.get(position);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        int dayValue = calendar.get(Calendar.DAY_OF_MONTH);
        int dayMonth = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int monthCurrent = mCalendar.get(Calendar.MONTH) +1;
        int yearCurrent = mCalendar.get(Calendar.YEAR);
        View view = convertView;
        if(view == null){
            view = mInterFace.inflate(R.layout.item_calendar,parent,false);
        }
        TextView tv_calendar_item = (TextView) view.findViewById(R.id.tv_item_calendar);
        TextView tv_event_item = (TextView) view.findViewById(R.id.event_calendar);
        if(dayMonth == monthCurrent && year == yearCurrent){
            tv_calendar_item.setText(String.valueOf(dayValue));
            tv_event_item.setText(".");
        }else{
            tv_calendar_item.setVisibility(View.GONE);
            tv_event_item.setVisibility(View.GONE);
        }

        return view;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return mList.indexOf(item);
    }
}
