package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        expcheck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ExpenseActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }

    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(),
                Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.iBills:
                expcategory_btn.setText("Bills");
                return true;

            case R.id.iCar:
                expcategory_btn.setText("Cars");
                return true;

            case R.id.iChildren:
                expcategory_btn.setText("Children");
                return true;

            case R.id.iClothes:
                expcategory_btn.setText("Clothes");
                return true;

            case R.id.iCommunications:
                expcategory_btn.setText("Communications");
                return true;

            case R.id.iCosmetics:
                expcategory_btn.setText("Cosmetics");
                return true;

            case R.id.iEducation:
                expcategory_btn.setText("Education");
                return true;

            case R.id.iEntertainment:
                expcategory_btn.setText("Entertainment");
                return true;

            case R.id.iFood:
                expcategory_btn.setText("Food");
                return true;

            case R.id.iGifts:
                expcategory_btn.setText("Gifts");
                return true;

            case R.id.iHealth:
                expcategory_btn.setText("Health");
                return true;

            case R.id.iHobby:
                expcategory_btn.setText("Hobby");
                return true;

            case R.id.iHouse:
                expcategory_btn.setText("House");
                return true;

            case R.id.iHygiene:
                expcategory_btn.setText("Hygiene");
                return true;

            case R.id.iMonthlyMemberships:
                expcategory_btn.setText("Monthly Memberships/Subscription");
                return true;

            case R.id.iPets:
                expcategory_btn.setText("Pets");
                return true;

            case R.id.iPocketMoney:
                expcategory_btn.setText("Pocket Money");
                return true;

            case R.id.iSports:
                expcategory_btn.setText("Sports");
                return true;

            case R.id.iToiletry:
                expcategory_btn.setText("Toiletry");
                return true;

            case R.id.iTransportation:
                expcategory_btn.setText("Transportation");
                return true;

            case R.id.iTravel:
                expcategory_btn.setText("Travel");
                return true;
        }

        return false;
    }
}

