package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class IncomeActivity extends AppCompatActivity {

    private Button one_incbtn, two_incbtn, three_incbtn, four_incbtn, five_incbtn, six_incbtn,
        seven_incbtn, eight_incbtn, nine_incbtn, zero_incbtn, dot_incbtn, del_incbtn, inccheck_btn,
            inccategory_btn;
    private EditText income_date, income_txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        one_incbtn = findViewById(R.id.one_incbtn);
        two_incbtn = findViewById(R.id.two_incbtn);
        three_incbtn = findViewById(R.id.three_incbtn);
        four_incbtn = findViewById(R.id.four_incbtn);
        five_incbtn = findViewById(R.id.five_incbtn);
        six_incbtn = findViewById(R.id.six_incbtn);
        seven_incbtn = findViewById(R.id.seven_incbtn);
        eight_incbtn = findViewById(R.id.eight_incbtn);
        nine_incbtn = findViewById(R.id.nine_incbtn);
        zero_incbtn = findViewById(R.id.zero_incbtn);
        dot_incbtn = findViewById(R.id.dot_incbtn);

        del_incbtn = findViewById(R.id.del_incbtn);
        inccheck_btn = findViewById(R.id.inccheck_btn);

        inccategory_btn = findViewById(R.id.inccategory_btn);

        income_date = findViewById(R.id.income_date);
        income_txtview = findViewById(R.id.inc_txtview);



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
        one_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "1");
            }
        });

        two_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "2");
            }
        });

        three_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "3");
            }
        });

        four_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "4");
            }
        });

        five_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "5");
            }
        });

        six_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "6");
            }
        });

        seven_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "7");
            }
        });

        eight_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "8");
            }
        });

        nine_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "9");
            }
        });

        zero_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + "0");
            }
        });

        dot_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_txtview.setText(income_txtview.getText() + ".");
                dot_incbtn.setEnabled(false);

            }
        });
//--------------------------------------------------------------------------------------------------

        inccheck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (IncomeActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }

    private boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(),
                Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.iAllowance:
                inccategory_btn.setText("Allowance");
                return true;

            case R.id.iCashAssist:
                inccategory_btn.setText("Cash Assisstance");
                return true;

            case R.id.iDeposits:
                inccategory_btn.setText("Deposits");
                return true;

            case R.id.iSalary:
                inccategory_btn.setText("Salary");
                return true;

            case R.id.iSavings:
                inccategory_btn.setText("Savings");
                return true;

        }
        return false;
    }
}