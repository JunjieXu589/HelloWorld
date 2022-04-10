package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;

import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.entity.Session;
import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;


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

        login.setOnClickListener(new View.OnClickListener() {//login按钮实现的功能
            @Override
            public void onClick(View view) {

                String inputAccount = account.getText().toString();
                String inputPwd = password.getText().toString();


                if(inputAccount.trim().equals("")){//判断用户是否输入了账户和密码
                    Toast.makeText(MainActivity.this, "Account Please！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(inputPwd.trim().equals("")){
                    Toast.makeText(MainActivity.this, "Password Please！", Toast.LENGTH_SHORT).show();
                    return;
                }

                //
                String[] args = new String[2];//Pass the arrays into identify() to determine whether the ID and password match
                args[0] = inputAccount ;
                args[1] = inputPwd;

                Boolean isPwdRight = identify(args);
                //确认用户输入的密码是否和数据库里的匹配

                if(isPwdRight){//如果用户密码正确
                    editor = pref.edit();
                    if(rememberPwd.isChecked()){//用户选择记住密码，则存入SharedPerference文件中
                        editor.putBoolean("remember_password",true);
                        editor.putString("account", inputAccount);
                        editor.putString("password", inputPwd);
                    }else{
                        editor.clear();
                    }
                    editor.apply();

                    Session session = new Session();//建立session，方便在不同页面之间传值
                    session.setUserID(inputAccount);

                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivityForResult(intent,1);
                }else{//密码错误就弹出提示
                    Toast.makeText(MainActivity.this, "Account or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    protected boolean identify(String[] args){
        String inputUserID = args[0];//ID and password entered by user
        String inputPsw = args[1];
        String password = "0";

        List<Customer> allCustomer = LitePal.findAll(Customer.class);
        for(Customer customer: allCustomer){//遍历表中所有customer
            if(inputUserID.equals(customer.getUserID())){
                password = customer.getPwd();
                break;
            }
        }

        if(inputPsw.equals(password)){
            return true;
        }else{//Toast提示在activity里
            return false;
        }
    }


}