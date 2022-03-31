package com.example.helloworld;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.entity.Customer;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button re_register = findViewById(R.id.re_register);
        re_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.re_username);
                EditText password = findViewById(R.id.re_password);
                EditText passwordAffirm = findViewById(R.id.re_affirm);
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();
                String inputAffirm = passwordAffirm.getText().toString();
                Customer user = new Customer();
                if (inputAffirm.equals(inputPassword)) {
                    //密码一致，储存账号
                    user.setUserID(inputUsername);
                    user.setPwd(inputPassword);
                    user.setCar("Unknown");
                    user.setPayment("Unknown");
                    user.setBalance(0);
                    user.setTelephone("Unknown");
                    user.save();//传回账号密码和初始数据到 数据库表

                    Intent intent = new Intent();
                    //intent.putExtra("userID", inputUsername);
                    Toast.makeText(Register.this,"Registration successful", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(Register.this,"The passwords are inconsistent", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}