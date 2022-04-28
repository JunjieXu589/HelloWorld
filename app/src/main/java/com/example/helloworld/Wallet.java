package com.example.helloworld;

import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.databinding.BalanceBinding;
import com.example.helloworld.entity.Session;


public class Wallet extends AppCompatActivity {
    private BalanceBinding binding;
    private TextView balance;
    private EditText chargeMoney;
    private Session session;
    private ActivityCollectUtil activityCollectUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balance);
        binding = BalanceBinding.inflate(getLayoutInflater());
//        View root = binding.getRoot();
//        setContentView(root);//设置显示的是那个layout文件

        //Aggregates all the activities in the stack, so that all the destroys are convenient for logout
        activityCollectUtil = new ActivityCollectUtil();
        activityCollectUtil.addActivity(this);//add this activity into activityCollectUtil's list

        session = new Session();

        balance = binding.walletBalance;
        String strBalance  =  String.valueOf(session.getBalance());//将float转化为String类型来表示余额
        balance.setText(strBalance);


    }
}