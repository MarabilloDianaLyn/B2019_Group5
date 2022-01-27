package com.example.financewise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

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

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                if (rgstr_name.getText().toString().equals("")){
                    Toast.makeText(RegistrationActivity.this, "Enter full name", Toast.LENGTH_SHORT).show();
                }else if(rgstr_contactno.getText().toString().equals("")){
                    Toast.makeText(RegistrationActivity.this, "Enter contact number", Toast.LENGTH_SHORT).show();
                }else if(rgstr_email.getText().toString().equals("")){
                    Toast.makeText(RegistrationActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                }else if(rgstr_password.getText().toString().equals("")){
                    Toast.makeText(RegistrationActivity.this, "Enter passwordd", Toast.LENGTH_SHORT).show();
                }

                HashMap<String, String> params = new HashMap<>();
                params.put("fullname", rgstr_name.getText().toString());
                params.put("contactno", rgstr_contactno.getText().toString());
                params.put("email", rgstr_contactno.getText().toString());
                params.put("password", rgstr_password.getText().toString());
                fw_register(params);


            }
        });
    }

    private void fw_register(HashMap <String, String> params){

        final ProgressDialog progressDialog = new ProgressDialog(RegistrationActivity.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Registering...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        NetworkService networkService = NetworkClient.getClient().create(NetworkService.class);
        Call<RegisterResponseModel> registerCall = networkService.fw_register(params);
        registerCall.enqueue(new Callback<RegisterResponseModel>() {
            @Override
            public void onResponse(Call<RegisterResponseModel> call, Response<RegisterResponseModel> response) {
                RegisterResponseModel responseBody = response.body();
                if (responseBody != null){
                    if (responseBody.getSuccess().equals("1")){
                        Toast.makeText(RegistrationActivity.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistrationActivity.this, LogInActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(RegistrationActivity.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<RegisterResponseModel> call, Throwable t) {
                progressDialog.dismiss();

            }
        });

    }
}