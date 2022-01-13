package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IncomeActivity extends AppCompatActivity {

    private Button one_btn, two_btn, three_btn, four_btn, five_btn, six_btn,
        seven_btn, eight_btn, nine_btn, zero_btn, dot_btn, inccategory_btn;
    private EditText income_date, income_txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        one_btn = findViewById(R.id.one_btn);
        two_btn = findViewById(R.id.two_btn);
        three_btn = findViewById(R.id.three_btn);
        four_btn = findViewById(R.id.four_btn);
        five_btn = findViewById(R.id.five_btn);
        six_btn = findViewById(R.id.six_btn);
        seven_btn = findViewById(R.id.seven_btn);
        eight_btn = findViewById(R.id.eight_btn);
        nine_btn = findViewById(R.id.nine_btn);
        zero_btn = findViewById(R.id.zero_btn);
        dot_btn = findViewById(R.id.dot_btn);
        inccategory_btn = findViewById(R.id.inccategory_btn);

        income_date = findViewById(R.id.income_date);
        income_txtview = findViewById(R.id.income_txtview);


        //code for the popup menu
        inccategory_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //---------------------------------

        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "1");
            }
        });

        two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "2");
            }
        });
    }
}