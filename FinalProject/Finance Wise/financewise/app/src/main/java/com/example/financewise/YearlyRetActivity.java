package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YearlyRetActivity extends AppCompatActivity {
    String yurladdress, yvalue;
    String[] ycategory;
    String[] ycategitem;
    String[] yamount;
    String[] ymonth;
    String[] yday;
    String[] yyear;
    ListView ylistView;
    BufferedInputStream yis;
    String yline=null;
    String yresult=null;

    Button yearsearch_Btn, selectYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_ret);

        ylistView = (ListView)findViewById(R.id.ylistView);

        selectYear = findViewById(R.id.selectyear);
        yearsearch_Btn = findViewById(R.id.year_btn);

        selectYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu ypopup = new PopupMenu(YearlyRetActivity.this, v);
                ypopup.setOnMenuItemClickListener(YearlyRetActivity.this::onMenuItemClick);

                ypopup.inflate(R.menu.year_popup);
                ypopup.show();
            }
        });

        yearsearch_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String yearshort=selectYear.getText().toString().trim();
                yvalue = yearshort;

                yurladdress = "https://b2019cc107group5.000webhostapp.com/fetchYear.php?year="+yvalue;

                StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
                collectYearData();
                CustomMonthListView customMonthListView=new CustomMonthListView(YearlyRetActivity.this,ycategory,ycategitem,yamount,ymonth,yday,yyear);
                ylistView.setAdapter(customMonthListView);
            }
        });

    }

    private void collectYearData() {
        //Connection
        try {
            URL url = new URL(yurladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            yis = new BufferedInputStream(con.getInputStream());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Context
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(yis));
            StringBuilder sb = new StringBuilder();
            while ((yline = br.readLine()) != null) {
                sb.append(yline + "\n");
            }
            yis.close();
            yresult = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //JSON
        try {
            JSONArray ja=new JSONArray(yresult);
            JSONObject jo=null;
            ycategory= new String[ja.length()];
            ycategitem= new String[ja.length()];
            yamount= new String[ja.length()];
            ymonth= new String[ja.length()];
            yday= new String[ja.length()];
            yyear= new String[ja.length()];

            for(int i=0; i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                ycategory[i]=jo.getString("category");
                ycategitem[i]=jo.getString("categitem");
                yamount[i]=jo.getString("amount");
                ymonth[i]=jo.getString("month");
                yday[i]=jo.getString("day");
                yyear[i]=jo.getString("year");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public boolean onMenuItemClick(MenuItem yearItem) {
        Toast.makeText(this, "Selected Item: " + yearItem.getTitle(),
                Toast.LENGTH_SHORT).show();
        switch (yearItem.getItemId()) {
            case R.id.i2020:
                selectYear.setText("2020");
                return true;

            case R.id.i2021:
                selectYear.setText("2021");
                return true;

            case R.id.i2022:
                selectYear.setText("2022");
                return true;

            case R.id.i2023:
                selectYear.setText("2023");
                return true;

            case R.id.i2024:
                selectYear.setText("2024");
                return true;

            case R.id.i2025:
                selectYear.setText("2025");
                return true;

            case R.id.i2026:
                selectYear.setText("2026");
                return true;

            case R.id.i2027:
                selectYear.setText("2027");
                return true;

            case R.id.i2028:
                selectYear.setText("2028");
                return true;

            case R.id.i2029:
                selectYear.setText("2029");
                return true;

            case R.id.i2030:
                selectYear.setText("2030");
                return true;

        }
            return false;
    }
}