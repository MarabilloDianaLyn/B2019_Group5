package com.example.financewise;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

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

        rgstr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname, email, password;
                fullname = String.valueOf(rgstr_name.getText());
                email = String.valueOf(rgstr_email.getText());
                password = String.valueOf(rgstr_password.getText());

                if (!fullname.equals("") && !email.equals("") && !password.equals("")){

                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                           String[] field = new String[3];
                            field[0] = "fullname";
                            field[1] = "email";
                            field[2] = "password";
                            String[] data = new String[3];
                            data[0] = fullname;
                            data[1] = email;
                            data[2] = password;
                            PutData putData = new PutData("https://b2019cc107group5.000webhostapp.com/signup.php", "POST", field, data);

                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Sign Up Success")) {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(), "All fields are required!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}