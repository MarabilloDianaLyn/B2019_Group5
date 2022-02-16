package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.FetchData;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    TextView expview, incview;
    Button expense_Btn, income_Btn;
    CardView history_Btn, future_Btn, monthly_Btn, yearly_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        expense_Btn = findViewById(R.id.expense_btn);
        income_Btn = findViewById(R.id.income_btn);
        history_Btn = findViewById(R.id.history_cv);
        monthly_Btn = findViewById(R.id.monthly_cv);
        yearly_Btn = findViewById(R.id.yearly_cv);
        future_Btn = findViewById(R.id.future_cv);
//--------------------------------------------------------------------------------------------------
        history_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
//--------------------------------------------------------------------------------------------------
       future_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, FutureExpActivity.class);
                startActivity(intent);
            }
        });
//--------------------------------------------------------------------------------------------------
        monthly_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MonthlyRetActivity.class);
                startActivity(intent);
            }
        });
//--------------------------------------------------------------------------------------------------
        yearly_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, YearlyRetActivity.class);
                startActivity(intent);
            }
        });
//--------------------------------------------------------------------------------------------------
       income_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DashboardActivity.this, IncomeActivity.class);
                startActivity(intent);
            }
        });
//--------------------------------------------------------------------------------------------------
        expense_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DashboardActivity.this, ExpenseActivity.class);
                startActivity(intent);
            }
        });
//--------------------------------------------------------------------------------------------------
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menuinflate,menu);

        return true;
    }
}