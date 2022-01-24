package com.example.financewise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.MutableDateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IncomeActivity extends AppCompatActivity {

    private Button one_incbtn, two_incbtn, three_incbtn, four_incbtn, five_incbtn, six_incbtn,
        seven_incbtn, eight_incbtn, nine_incbtn, zero_incbtn, dot_incbtn, del_incbtn, inccheck_btn,
            inccategory_btn;
    private EditText income_date, income_txtview;



    private DatabaseReference budgetRef;
    private FirebaseAuth mAuth;
    private ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        mAuth = FirebaseAuth.getInstance();
        budgetRef = FirebaseDatabase.getInstance().getReference().child("budget").
                child(mAuth.getCurrentUser().getUid());
        loader = new ProgressDialog(this);

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

                String budgetAmount = income_txtview.getText().toString();
                String budgetItem = inccategory_btn.getText().toString();

                if (TextUtils.isEmpty(budgetAmount)){
                    income_txtview.setError("Please insert amount");
                    return;
                }

                if (budgetItem.equals("Choose Category")){
                    Toast.makeText(IncomeActivity.this,
                            "Please select a valid item", Toast.LENGTH_SHORT).show();
                }
                else{
                    loader.setMessage("Adding an item");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();

                    String id = budgetRef.push().getKey();
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Calendar cal = Calendar.getInstance();
                    String date = dateFormat.format(cal.getTime());

                    MutableDateTime epoch = new MutableDateTime();
                    epoch.setDate(0);
                    DateTime now = new DateTime();
                    Months months = Months.monthsBetween(epoch, now);

                    Data data = new Data(budgetItem, date, id, Integer.parseInt(budgetAmount), months.getMonths());
                    budgetRef.child(id).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(IncomeActivity.this, "Income added successfully", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(IncomeActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }
                            loader.dismiss();
                        }
                    });

                }

                Intent intent = new Intent (IncomeActivity.this, RetrieveActivity.class);
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