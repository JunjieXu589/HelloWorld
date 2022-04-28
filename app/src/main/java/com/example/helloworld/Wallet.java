package com.example.helloworld;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.databinding.BalanceBinding;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.entity.Session;
import com.example.helloworld.entity.User;


public class Wallet extends AppCompatActivity {
    private BalanceBinding binding;
    private TextView balance;
    private EditText chargeMoney;
    private Button pay;
    private Session session;
    private ActivityCollectUtil activityCollectUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.balance);
        binding = BalanceBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);//set the content view with layout文件

        //Aggregates all the activities in the stack, so that all the destroys are convenient for logout
        activityCollectUtil = new ActivityCollectUtil();
        activityCollectUtil.addActivity(this);//add this activity into activityCollectUtil's list

        session = new Session();//初始化

        balance = binding.walletBalance;//Get the component from
        chargeMoney = binding.chargeAmount;//page by using the binding class
        pay = binding.confirmCharge;
        String strBalance  =  String.valueOf(session.getBalance());//将float转化为String类型来表示余额
        balance.setText(strBalance);//show balance in page

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String money = chargeMoney.getText().toString();
                //
                //需要对money验证，确保是数字
                Float balanceNow = session.getBalance()+ Float.valueOf(money);

                Customer customer = new Customer();
                customer.setBalance(balanceNow);
                customer.updateAll("userID = ?","xujunjie@bupt.edu.cn");//update database

                balance.setText(String.valueOf(balanceNow));
                session.setBalance(balanceNow);
                Toast.makeText(Wallet.this,"Charge successful",Toast.LENGTH_SHORT).show();
            }
        });


    }
}