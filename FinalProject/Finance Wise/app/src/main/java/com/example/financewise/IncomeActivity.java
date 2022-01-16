package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

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



//code for popup menu
        inccategory_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu mpopup = new PopupMenu(IncomeActivity.this, v);
                mpopup.setOnMenuItemClickListener(IncomeActivity.this::onMenuItemClick);

                mpopup.inflate(R.menu.income_popup);
                mpopup.show();
            }
        });
//-----------------------------------------------------------------------------------

//function of numeric buttons
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

        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "3");
            }
        });

        four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "4");
            }
        });

        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "5");
            }
        });

        six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "6");
            }
        });

        seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "7");
            }
        });

        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "8");
            }
        });

        nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "9");
            }
        });

        zero_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "0");
            }
        });

        dot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + ".");
                dot_btn.setEnabled(false);

            }
        });
//--------------------------------------------------------------------------------------------------

    }

    private boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(),
                Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.iAllowance:
                return true;

            case R.id.iCashAssist:
                return true;

            case R.id.iDeposits:
                return true;

            case R.id.iSalary:
                return true;

            case R.id.iSavings:
                return true;

        }
        return false;
    }
}