package com.example.financewise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText rgstr_name, rgstr_contactno, rgstr_email, rgstr_password;
    private Button rgstr_btn;
    private TextView rgstrloginQn;

    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

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
                String emailString = rgstr_email.getText().toString();
                String passwordString = rgstr_password.getText().toString();
                String nameString = rgstr_name.getText().toString();
                String contactString = rgstr_contactno.getText().toString();

                if (TextUtils.isEmpty(nameString)){
                    rgstr_email.setError("Your full name is required");
                }
                if (TextUtils.isEmpty(contactString)){
                    rgstr_email.setError("Contact number is required");
                }
                if (TextUtils.isEmpty(emailString)){
                    rgstr_email.setError("Email is required");
                }
                if (TextUtils.isEmpty(passwordString)){
                    rgstr_password.setError("Password is required");
                }
                else {
                    progressDialog.setMessage("Signing up");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    mAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(RegistrationActivity.this, DashboardActivity.class);
                                startActivity(intent);
                                finish();
                                progressDialog.dismiss();
                            }
                            else{
                                Toast.makeText(RegistrationActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });
                }
            }
        }); 
    }
}