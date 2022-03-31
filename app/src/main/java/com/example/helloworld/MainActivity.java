package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;

import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.litepal.tablemanager.Connector;


public class MainActivity extends AppCompatActivity {

    private TextView register;
    private EditText account;
    private EditText password;
    private CheckBox rememberPwd;
    private Button login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        register = findViewById(R.id.lg_register);//跳转到注册页面去
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivityForResult(intent,1);
            }
        });


        pref = getSharedPreferences("login_info",MODE_PRIVATE);//
        account = findViewById(R.id.lg_username);//获取login页面的各个组件
        password =  findViewById(R.id.lg_password);
        rememberPwd = findViewById(R.id.lg_rememberPsd);
        login = findViewById(R.id.lg_login);

        boolean isRemeber = pref.getBoolean("remember_password",false);
        if(isRemeber) {//如果上次选择了记住密码
            //将账号和密码都填到文本框中
            String prefAccount = pref.getString("account","");
            String prefPassword = pref.getString("password","");
            account.setText(prefAccount);
            password.setText(prefPassword);
            rememberPwd.setChecked(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputAccount = account.getText().toString();
                String inputPwd = password.getText().toString();

                Connector.getDatabase();//使用LitePal获取数据库？


                if(inputAccount.trim().equals("")){//判断用户是否输入了账户和密码
                    Toast.makeText(MainActivity.this, "Account Please！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(inputPwd.trim().equals("")){
                    Toast.makeText(MainActivity.this, "Password Please！", Toast.LENGTH_SHORT).show();
                    return;
                }
                //这里缺密码是否正确的检查
                Boolean isPwdRight = true;


                if(isPwdRight){//如果用户密码正确
                    editor = pref.edit();
                    if(rememberPwd.isChecked()){//用户选择记住密码
                        editor.putBoolean("remember_password",true);
                        editor.putString("account", inputAccount);
                        editor.putString("password", inputPwd);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivityForResult(intent,1);
                }else{//密码错误就弹出提示
                    Toast.makeText(MainActivity.this, "Account or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}