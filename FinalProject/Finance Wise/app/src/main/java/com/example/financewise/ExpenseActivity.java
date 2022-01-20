package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ExpenseActivity extends AppCompatActivity {

    private Button one_expbtn, two_expbtn, three_expbtn, four_expbtn, five_expbtn, six_expbtn,
            seven_expbtn, eight_expbtn, nine_expbtn, zero_expbtn, dot_expbtn, del_expbtn, expcheck_btn,
            expcategory_btn;
    private EditText expense_date, expense_txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        //
        one_expbtn = findViewById(R.id.one_expbtn);
        two_expbtn = findViewById(R.id.two_expbtn);
        three_expbtn = findViewById(R.id.three_expbtn);
        four_expbtn = findViewById(R.id.four_expbtn);
        five_expbtn = findViewById(R.id.five_expbtn);
        six_expbtn = findViewById(R.id.six_expbtn);
        seven_expbtn = findViewById(R.id.seven_expbtn);
        eight_expbtn = findViewById(R.id.eight_expbtn);
        nine_expbtn = findViewById(R.id.nine_expbtn);
        zero_expbtn = findViewById(R.id.zero_expbtn);
        dot_expbtn = findViewById(R.id.dot_expbtn);
        expcategory_btn = findViewById(R.id.expcategory_btn);

        del_expbtn = findViewById(R.id.del_expbtn);
        expcheck_btn = findViewById(R.id.expcheck_btn);

        expense_date = findViewById(R.id.expense_date);
        expense_txtview = findViewById(R.id.exp_txtview);
        //-------------------------------------------------


//code for popup menu
        expcategory_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu mpopup = new PopupMenu(ExpenseActivity.this, v);
                mpopup.setOnMenuItemClickListener(ExpenseActivity.this::onMenuItemClick);

                mpopup.inflate(R.menu.expense_popup);
                mpopup.show();
            }
        });

//------------------------------------------------------------------------------------------------

        //function for numeric buttons
        one_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "1");
            }
        });
        
        two_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "2");
            }
        });
        
        three_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "3");
            }
        });
        
        four_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "4");
            }
        });
        
        five_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "5");
            }
        });
        
        six_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "6");
            }
        });
        
        seven_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "7");
            }
        });
        
        eight_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "8");
            }
        });
        
        nine_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "9");
            }
        });
        
        zero_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + "0");
            }
        });

        dot_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_txtview.setText(expense_txtview.getText() + ".");
                dot_expbtn.setEnabled(false);
            }
        });
        
        //-----------------------------------------------------------
    }

    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(),
                Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.iBills:
                return true;

            case R.id.iCar:
                return true;

            case R.id.iChildren:
                return true;

            case R.id.iClothes:
                return true;

            case R.id.iCommunications:
                return true;

            case R.id.iCosmetics:
                return true;

            case R.id.iEducation:
                return true;

            case R.id.iEntertainment:
                return true;

            case R.id.iFood:
                return true;

            case R.id.iGifts:
                return true;

            case R.id.iHealth:
                return true;

            case R.id.iHobby:
                return true;

            case R.id.iHouse:
                return true;

            case R.id.iHygiene:
                return true;

            case R.id.iMonthlyMemberships:
                return true;

            case R.id.iPets:
                return true;

            case R.id.iPocketMoney:
                return true;

            case R.id.iSports:
                return true;

            case R.id.iToiletry:
                return true;

            case R.id.iTransportation:
                return true;

            case R.id.iTravel:
                return true;
        }

        return false;
    }
}

