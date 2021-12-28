package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    private EditText rgstr_name, rgstr_contactno, rgstr_email, rgstr_password;
    private Button rgstr_btn;
    private TextView rgstrloginQn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        rgstr_name = findViewById(R.id.rgstr_name);
        rgstr_contactno = findViewById(R.id.rgstr_contactno);
        rgstr_email = findViewById(R.id.rgstr_email);
        rgstr_password = findViewById(R.id.rgstr_password);
        rgstr_btn = findViewById(R.id.rgstr_btn);
        rgstrloginQn = findViewById(R.id.rgstrloginQn);

        rgstrloginQn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(RegistrationActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
    }
}