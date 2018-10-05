package com.anhttvn.loaddata;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.anhttvn.loaddata.activity.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private String url ="http://www.tienganh123.com/tieng-anh-tre-em-theo-chu-de";
    @AfterViews
    void init(){

    }
    @Click(R.id.btn_vocabulary)
    void clickLoadData(){
        loadDataVocabulary(url);
    }
    private void loadDataVocabulary(String url){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("anhtt" ,"heloo" +"");
                ParseHtml(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request queue
        requestQueue.add(stringRequest);

    }
    private void ParseHtml(String url) {
        Document doc = Jsoup.parse(url);
        Log.d("anhtt" ,"heloo 2" +"");
        for (Element ul : doc.select("ul[class=ptl_content]")) {
            Log.d("anhtt" ,"heloo 1" +"");
            for(Element li_select: ul.select("li")){
                Elements title_select_one = li_select.select("div[class=lng_img ptl_img]");
                Elements title_select_twoo = title_select_one.select("a[title]");
                Elements img_select = title_select_twoo.select("img[rsc]");
                Log.d("anhtt" ,title_select_twoo +"");
            }

        }
    }
}
