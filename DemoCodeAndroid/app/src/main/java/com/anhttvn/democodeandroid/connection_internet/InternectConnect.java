package com.anhttvn.democodeandroid.connection_internet;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anhttvn.democodeandroid.R;

/**
 * Created by Huu Duan on 1/15/2018.
 * @author
 */
public class InternectConnect extends Activity {

    private Button btnCheck;
    private TextView tv_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        tv_message = (TextView) findViewById(R.id.tv_message);
        btnCheck = (Button) findViewById(R.id.btn_check_connect);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkConnectInternet()){
                    tv_message.setText(" Connected ");
                    Toast.makeText(InternectConnect.this, " Connected ", Toast.LENGTH_LONG).show();
                }else{
                    tv_message.setText("Not Connected ");
                    Toast.makeText(InternectConnect.this, " Not Connected ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public final boolean checkConnectInternet () {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {

            // if connected with internet


            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED  ) {


            return false;
        }
        return false;
    }
}
