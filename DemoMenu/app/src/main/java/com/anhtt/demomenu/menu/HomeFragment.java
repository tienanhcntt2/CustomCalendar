package com.anhtt.demomenu.menu;

import android.app.Fragment;
import android.widget.Toast;

import com.anhtt.demomenu.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by Huu Duan on 6/16/2016.
 */
@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    public HomeFragment newInstance() {
        return new HomeFragment_();
    }
    @AfterViews
    void init(){
        Toast.makeText(getActivity(),"show",Toast.LENGTH_SHORT).show();
    }
}
