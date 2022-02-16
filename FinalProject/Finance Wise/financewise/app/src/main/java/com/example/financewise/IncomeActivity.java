package com.example.financewise;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
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

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IncomeActivity extends AppCompatActivity {

    Button one_incbtn, two_incbtn, three_incbtn, four_incbtn, five_incbtn, six_incbtn,
            seven_incbtn, eight_incbtn, nine_incbtn, zero_incbtn, dot_incbtn, del_incbtn, inccheck_btn,
            inccategory_btn;
    EditText income_date;
    ProgressBar progressBar;
    String mm;
    int dd, yyyy, mp;
    TextInputEditText inc_amount;
    DatePickerDialog.OnDateSetListener setListener;

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
        progressBar = findViewById(R.id.incomeprogress);

        inccategory_btn = findViewById(R.id.inccategory_btn);

        income_date = findViewById(R.id.income_date);
        inc_amount = findViewById(R.id.inc_amount);

//--------------------------------------------------------------------------------------------------
        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        income_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(IncomeActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        dd = day;
                        yyyy = year;

                        mp = month;

                        if(month==1){
                            mm = "Jan";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==2){
                            mm = "Feb";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==3){
                            mm = "Mar";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==4){
                            mm = "Apr";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==5){
                            mm = "May";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==6){
                            mm = "Jun";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==7){
                            mm = "Jul";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==8){
                            mm = "Aug";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==9){
                            mm = "Sep";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==10){
                            mm = "Oct";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==11){
                            mm = "Nov";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                        if(month==12){
                            mm = "Dec";
                            String date = mm+"/"+dd+"/"+yyyy;
                            income_date.setText(date);
                        }
                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });
//--------------------------------------------------------------------------------------------------
        one_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "1");
            }
        });

        two_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "2");
            }
        });

        three_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "3");
            }
        });

        four_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "4");
            }
        });

        five_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "5");
            }
        });

        six_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "6");
            }
        });

        seven_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "7");
            }
        });

        eight_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "8");
            }
        });

        nine_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "9");
            }
        });

        zero_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + "0");
            }
        });

        dot_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc_amount.setText(inc_amount.getText() + ".");
                dot_incbtn.setEnabled(false);

            }
        });

        del_incbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = inc_amount.getText().toString();
                s = s.substring(0, s.length()-1);
                inc_amount.setText(s);
            }
        });
//--------------------------------------------------------------------------------------------------
        inccategory_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu mpopup = new PopupMenu(IncomeActivity.this, v);
                mpopup.setOnMenuItemClickListener(IncomeActivity.this::onMenuItemClick);

                mpopup.inflate(R.menu.income_popup);
                mpopup.show();

            }
        });
//--------------------------------------------------------------------------------------------------
        inccheck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String category, categitem, amount, month, day, year;
                category = "Income";
                categitem = String.valueOf(inccategory_btn.getText());
                amount = String.valueOf(inc_amount.getText());
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
                                        Intent intent = new Intent(getApplicationContext(),HistoryActivity.class);
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
//--------------------------------------------------------------------------------------------------
    }

//--------------------------------------------------------------------------------------------------
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "Selected Item: " + menuItem.getTitle(),
                Toast.LENGTH_SHORT).show();

        switch (menuItem.getItemId()) {
            case R.id.iAllowance:
                inccategory_btn.setText("Allowance");
                return true;

            case R.id.iCA:
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