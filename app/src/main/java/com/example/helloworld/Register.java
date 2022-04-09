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
                if (inputAffirm.equals(inputPassword)) {//两次输入的密码一致

                    if(CheckID(inputUsername)&&CheckPsw(inputPassword)){//输入的Username和password符合格式要求

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

                    }
                } else {
                    Toast.makeText(Register.this,"The passwords are inconsistent", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    protected boolean CheckID(String string){
        //To Do 添加邮件格式的检查 正确return true，错误返回false并弹出toast

        return true;
    }



    protected boolean CheckPsw(String pswA){//用于检测密码格式是否符合8到20位且含有字母

        boolean isDigit = false;//Boolean is used to determine whether the password contains numbers
        boolean isLetter = false;//Boolean is used to determine whether the password contains letters
        boolean isPswRight = true;//Used to record whether the password format is correct

        for(int i =0; i < pswA.length(); i++) {
            if(Character.isDigit(pswA.charAt(i))) {
                isDigit = true;
            } else if(Character.isLetter(pswA.charAt(i))) {
                isLetter = true;
            }
        }
        String regex = "^[a-zA-Z0-9]{8,20}$";
        isPswRight = isDigit && isLetter && pswA.matches(regex);//isPswRight is boolean, Represents whether the password is in the correct format

        if(isPswRight){
            return true;
        }else{
            Toast.makeText(Register.this,"Your Password length must be between 8 and 20 digits and must contain both letters and numbers", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}