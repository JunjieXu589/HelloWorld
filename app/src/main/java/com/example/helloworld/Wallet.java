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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balance);
        binding = BalanceBinding.inflate(getLayoutInflater());
//        View root = binding.getRoot();
//        setContentView(root);//设置显示的是那个layout文件
        session = new Session();

        balance = binding.walletBalance;
//        String strBalance    //将float转化为String类型来表示余额 找不到适合的方法！！
//        balance.setText(strBalance);


    }
}