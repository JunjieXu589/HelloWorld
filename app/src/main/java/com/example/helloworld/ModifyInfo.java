package com.example.helloworld;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.databinding.UserInfoBinding;
import com.example.helloworld.entity.Session;

public class ModifyInfo extends AppCompatActivity {
    private Session session;
    private EditText car;
    private EditText telephone;
    private UserInfoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.user_info);//效果和使用binding一样
        binding = UserInfoBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        car = binding.userInfoCar;//获取页面组件
        telephone = binding.userInfoTel;
        session = new Session();
        car.setText(session.getCar());
        telephone.setText(session.getTel());


    }
}