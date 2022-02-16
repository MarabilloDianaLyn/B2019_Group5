package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyRetActivity extends AppCompatActivity {
    String murladdress;
    String[] mcategory;
    String[] mcategitem;
    String[] mamount;
    String[] mmonth;
    String[] mday;
    String[] myear;
    ListView mlistView;
    BufferedInputStream mis;
    String mline=null;
    String mresult=null;
    int value;

    Button monthsearch_Btn, selectMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_ret);

        mlistView = (ListView)findViewById(R.id.mlistView);

        selectMonth = findViewById(R.id.selectmonth);
        monthsearch_Btn = findViewById(R.id.month_btn);

        selectMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu ipopup = new PopupMenu(MonthlyRetActivity.this, v);
                ipopup.setOnMenuItemClickListener(MonthlyRetActivity.this::onMenuItemClick);

                ipopup.inflate(R.menu.month_popup);
                ipopup.show();
            }
        });

        monthsearch_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String monthshort=selectMonth.getText().toString().trim();

                if(monthshort.equals("January")){
                    value = 1;
                }
                else if(monthshort.equals("February")){
                    value = 2;
                }
                else if(monthshort.equals("March")){
                    value = 3;
                }
                else if(monthshort.equals("April")){
                    value = 4;
                }
                else if(monthshort.equals("May")){
                    value = 5;
                }
                else if(monthshort.equals("June")){
                    value = 6;
                }
                else if(monthshort.equals("July")){
                    value = 7;
                }
                else if(monthshort.equals("August")){
                    value = 8;
                }
                else if(monthshort.equals("September")){
                    value = 9;
                }
                else if(monthshort.equals("October")){
                    value = 10;
                }
                else if(monthshort.equals("November")){
                    value = 11;
                }
                else if(monthshort.equals("December")){
                    value = 12;
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please select month", Toast.LENGTH_SHORT).show();
                }

                murladdress = "https://b2019cc107group5.000webhostapp.com/fetchData.php?month="+value;

                StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
                collectMonthData();
                CustomMonthListView customMonthListView=new CustomMonthListView(MonthlyRetActivity.this,mcategory,mcategitem,mamount,mmonth,mday,myear);
                mlistView.setAdapter(customMonthListView);

            }
        });

    }

    private void collectMonthData() {

        //Connection
        try {
            URL url = new URL(murladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            mis = new BufferedInputStream(con.getInputStream());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Context
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(mis));
            StringBuilder sb = new StringBuilder();
            while ((mline = br.readLine()) != null) {
                sb.append(mline + "\n");
            }
            mis.close();
            mresult = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //JSON
        try {
            JSONArray ja=new JSONArray(mresult);
            JSONObject jo=null;
            mcategory= new String[ja.length()];
            mcategitem= new String[ja.length()];
            mamount= new String[ja.length()];
            mmonth= new String[ja.length()];
            mday= new String[ja.length()];
            myear= new String[ja.length()];

            for(int i=0; i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                mcategory[i]=jo.getString("category");
                mcategitem[i]=jo.getString("categitem");
                mamount[i]=jo.getString("amount");
                mmonth[i]=jo.getString("month");
                mday[i]=jo.getString("day");
                myear[i]=jo.getString("year");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public boolean onMenuItemClick(MenuItem monthItem) {
        Toast.makeText(this, "Selected Item: " + monthItem.getTitle(),
                Toast.LENGTH_SHORT).show();

        switch (monthItem.getItemId()){
            case R.id.iJan:
                selectMonth.setText("January");
                return true;

            case R.id.iFeb:
                selectMonth.setText("February");
                return true;

            case R.id.iMar:
                selectMonth.setText("March");
                return true;

            case R.id.iApr:
                selectMonth.setText("April");
                return true;

            case R.id.iMay:
                selectMonth.setText("May");
                return true;

            case R.id.iJune:
                selectMonth.setText("June");
                return true;

            case R.id.iJul:
                selectMonth.setText("July");
                return true;

            case R.id.iAug:
                selectMonth.setText("August");
                return true;

            case R.id.iSep:
                selectMonth.setText("September");
                return true;

            case R.id.iOct:
                selectMonth.setText("October");
                return true;

            case R.id.iNov:
                selectMonth.setText("November");
                return true;

            case R.id.iDec:
                selectMonth.setText("December");
                return true;
        }
        return false;
    }
}