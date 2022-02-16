package com.example.financewise;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextFullname, textInputEditTextUsername,
            textInputEditTextPassword,textInputEditTextEmail;
    Button btn_register;
    TextView qn_register;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputEditTextFullname = findViewById(R.id.registerfullname);
        textInputEditTextUsername = findViewById(R.id.registerusername);
        textInputEditTextEmail = findViewById(R.id.registeremail);
        textInputEditTextPassword = findViewById(R.id.registerpassword);
        btn_register = findViewById(R.id.register_btn);
        qn_register = findViewById(R.id.registerQn);
        progressBar = findViewById(R.id.signupprogress);

        qn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname, email, username, password;
                fullname = String.valueOf(textInputEditTextFullname.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());

                if(!fullname.equals("") && !email.equals("") && !username.equals("") && !password.equals("")){
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[4];
                            field[0] = "fullname";
                            field[1] = "username";
                            field[2] = "password";
                            field[3] = "email";
                            String[] data = new String[4];
                            data[0] = fullname;
                            data[1] = username;
                            data[2] = password;
                            data[3] = email;
                            PutData putData = new PutData("https://b2019cc107group5.000webhostapp.com/signup.php", "POST", field, data);
                            if (putData.startPut()){
                                if (putData.onComplete()){
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.trim().equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
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
                else{
                    Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}