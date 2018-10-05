package com.anhtt.demomenu.menu;

import android.app.Fragment;

import com.anhtt.demomenu.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by Huu Duan on 6/16/2016.
 */
@EFragment(R.layout.fragment_setting)
public class SettingFragment extends Fragment {
    public SettingFragment newInstance(){
        return new SettingFragment_();
    }
    @AfterViews
    void init(){

    }
}
