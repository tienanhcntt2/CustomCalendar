package com.anhtt.demomenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.anhtt.demomenu.menu.MenuHome_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Click(R.id.btnMenu)
    void clickMenu(){
        Intent intent = new Intent(this, MenuHome_.class);
        startActivity(intent);
    }

}
