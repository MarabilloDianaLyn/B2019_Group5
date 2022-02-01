package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LogInActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button login_btn;
    TextView loginQn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        textInputEditTextUsername = findViewById(R.id.loginusername);
        textInputEditTextPassword = findViewById(R.id.loginpassword);
        login_btn = findViewById(R.id.login_btn);
        loginQn = findViewById(R.id.loginQn);
        progressBar = findViewById(R.id.loginprogress);

        loginQn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}