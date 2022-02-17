package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.sql.Date;
import java.util.Calendar;

public class ExpenseActivity extends AppCompatActivity {

    Button one_expbtn, two_expbtn, three_expbtn, four_expbtn, five_expbtn, six_expbtn,
            seven_expbtn, eight_expbtn, nine_expbtn, zero_expbtn, dot_expbtn, del_expbtn, expcheck_btn,
            expcategory_btn;
    EditText expense_date;
    TextInputEditText exp_amount;
    ProgressBar progressBar;
    DatePickerDialog.OnDateSetListener setListener;

    String mm;

    int dd, yyyy, mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

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

        del_expbtn = findViewById(R.id.del_expbtn);
        expcheck_btn = findViewById(R.id.expcheck_btn);

        expcategory_btn = findViewById(R.id.expcategory_btn);
        progressBar = findViewById(R.id.expenseprogress);

        expense_date = findViewById(R.id.expense_date);
        exp_amount = findViewById(R.id.exp_amount);
//--------------------------------------------------------------------------------------------------
        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        expense_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ExpenseActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        dd = day;
                        yyyy = year;

                        mp = month;

                        if(month==1){
                            mm = "Jan";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==2){
                            mm = "Feb";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==3){
                            mm = "Mar";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==4){
                            mm = "Apr";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==5){
                            mm = "May";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==6){
                            mm = "Jun";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==7){
                            mm = "Jul";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==8){
                            mm = "Aug";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==9){
                            mm = "Sep";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==10){
                            mm = "Oct";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==11){
                            mm = "Nov";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                        if(month==12){
                            mm = "Dec";
                            String date = mm+"/"+dd+"/"+yyyy;
                            expense_date.setText(date);
                        }
                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });

//--------------------------------------------------------------------------------------------------
        expcategory_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu mpopup = new PopupMenu(ExpenseActivity.this, v);
                mpopup.setOnMenuItemClickListener(ExpenseActivity.this::onMenuItemClick);

                mpopup.inflate(R.menu.expense_popup);
                mpopup.show();
            }
        });

//--------------------------------------------------------------------------------------------------
        one_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "1");
            }
        });

        two_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "2");
            }
        });

        three_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "3");
            }
        });

        four_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "4");
            }
        });

        five_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "5");
            }
        });

        six_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "6");
            }
        });

        seven_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "7");
            }
        });

        eight_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "8");
            }
        });

        nine_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "9");
            }
        });

        zero_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + "0");
            }
        });

        dot_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp_amount.setText(exp_amount.getText() + ".");
                dot_expbtn.setEnabled(false);
            }
        });

        del_expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = exp_amount.getText().toString();
                s = s.substring(0, s.length()-1);
                exp_amount.setText(s);
            }
        });

//--------------------------------------------------------------------------------------------------
        expcheck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category, categitem, amount, month, day, year;
                category = "Expense";
                categitem = String.valueOf(expcategory_btn.getText());
                amount = String.valueOf(exp_amount.getText());
                month = String.valueOf(mp);
                day = String.valueOf(dd);
                year = String.valueOf(yyyy);

                if (!amount.equals("") && !categitem.equals("Choose Category")){
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[6];
                            field[0] = "category";
                            field[1] = "categitem";
                            field[2] = "amount";
                            field[3] = "month";
                            field[4] = "day";
                            field[5] = "year";
                            String[] data = new String[6];
                            data[0] = category;
                            data[1] = categitem;
                            data[2] = amount;
                            data[3] = month;
                            data[4] = day;
                            data[5] = year;
                            PutData putData = new PutData("https://b2019cc107group5.000webhostapp.com/addval.php", "POST", field, data);
                            if(putData.startPut()){
                                if(putData.onComplete()){
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.trim().equals("added successfully")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }
                else if (categitem.equals("Choose Category")){
                    Toast.makeText(getApplicationContext(), "Please select category", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//--------------------------------------------------------------------------------------------------
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "Selected Item: " + menuItem.getTitle(),
                Toast.LENGTH_SHORT).show();

        switch (menuItem.getItemId()) {
            case R.id.iBills:
                expcategory_btn.setText("Bills");
                return true;

            case R.id.iCar:
                expcategory_btn.setText("Cars");
                return true;

            case R.id.iClothes:
                expcategory_btn.setText("Clothes");
                return true;

            case R.id.iCommunication:
                expcategory_btn.setText("Communication");
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

            case R.id.iHygiene:
                expcategory_btn.setText("Hygiene");
                return true;

            case R.id.iMMS:
                expcategory_btn.setText("Memberships/Subscription");
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