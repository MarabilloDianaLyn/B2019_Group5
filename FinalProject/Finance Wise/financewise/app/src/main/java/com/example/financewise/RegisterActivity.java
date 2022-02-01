package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword,
            textInputEditTextFullname, textInputEditTextEmail;
    Button rgstr_btn;
    TextView rgstrQn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputEditTextFullname = findViewById(R.id.registerfullname);
        textInputEditTextUsername = findViewById(R.id.registerusername);
        textInputEditTextEmail = findViewById(R.id.registeremail);
        textInputEditTextPassword = findViewById(R.id.registerpassword);
        rgstr_btn = findViewById(R.id.register_btn);
        rgstrQn = findViewById(R.id.registerQn);

        rgstrQn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}