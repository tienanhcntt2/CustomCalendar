package com.anhtt.demomenu.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhtt.demomenu.R;

import java.util.ArrayList;

/**
 * Created by Huu Duan on 6/14/2016.
 * @author anhtt
 */
public class MenuAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<NavItem> mList;
    private LayoutInflater mLayoutInterface;
    public MenuAdapter(Context context,ArrayList<NavItem> list){
        mContext = context;
        mList = list;
        mLayoutInterface = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        private TextView mTitle;
        private ImageView mIcon;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = mLayoutInterface.inflate(R.layout.item_menu,null);
            holder = new ViewHolder();
            holder.mTitle = (TextView) convertView.findViewById(R.id.ic_title);
            holder.mIcon = (ImageView) convertView.findViewById(R.id.ic_menu);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        NavItem navItem = mList.get(position);
        holder.mIcon.setBackgroundResource(navItem.getMIcon());
        holder.mTitle.setText(navItem.getMTitle());
        return convertView;
    }
}
