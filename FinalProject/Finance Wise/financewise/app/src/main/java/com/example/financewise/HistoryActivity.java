package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HistoryActivity extends AppCompatActivity {

    String urladdress="https://b2019cc107group5.000webhostapp.com/try.php";
    String[] category;
    String[] categitem;
    String[] amount;
    String[] month;
    String[] day;
    String[] year;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listView = (ListView)findViewById(R.id.lview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        CustomListView customListView=new CustomListView(this,category,categitem,amount,month,day,year);
        listView.setAdapter(customListView);

    }

    private void collectData() {
        //Connection
        try {
            URL url = new URL(urladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Context
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //JSON
        try {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            category= new String[ja.length()];
            categitem= new String[ja.length()];
            amount= new String[ja.length()];
            month= new String[ja.length()];
            day= new String[ja.length()];
            year= new String[ja.length()];

            for(int i=0; i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                category[i]=jo.getString("category");
                categitem[i]=jo.getString("categitem");
                amount[i]=jo.getString("amount");
                month[i]=jo.getString("month");
                day[i]=jo.getString("day");
                year[i]=jo.getString("year");

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}