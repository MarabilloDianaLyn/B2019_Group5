package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class FutureExpActivity extends AppCompatActivity {

    String furladdress="https://b2019cc107group5.000webhostapp.com/try.php";
    String[] fcategory;
    String[] fcategitem;
    String[] famount;
    String[] fmonth;
    String[] fday;
    String[] fyear;
    BufferedInputStream fis;
    String fline=null;
    String fresult=null;

    ListView flistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_exp);

        flistView = findViewById(R.id.flview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectFData();
        CustomFutureListView customFutureListView=new CustomFutureListView(this,fcategory,fcategitem,famount,fmonth,fday,fyear);
        flistView.setAdapter(customFutureListView);

    }

    private void collectFData() {
        //Connection
        try {
            URL url = new URL(furladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            fis = new BufferedInputStream(con.getInputStream());


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Context
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            while ((fline = br.readLine()) != null) {
                sb.append(fline + "\n");
            }
            fis.close();
            fresult = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //JSON
        try {
            JSONArray ja=new JSONArray(fresult);
            JSONObject jo=null;
            fcategory= new String[ja.length()];
            fcategitem= new String[ja.length()];
            famount= new String[ja.length()];
            fmonth= new String[ja.length()];
            fday= new String[ja.length()];
            fyear= new String[ja.length()];

            for(int i=0; i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                fcategory[i]=jo.getString("category");
                fcategitem[i]=jo.getString("categitem");
                famount[i]=jo.getString("amount");
                fmonth[i]=jo.getString("month");
                fday[i]=jo.getString("day");
                fyear[i]=jo.getString("year");

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}