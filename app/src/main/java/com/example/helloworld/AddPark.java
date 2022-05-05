package com.example.helloworld;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.databinding.AddParkBinding;
import com.example.helloworld.databinding.AllParkBinding;
import com.example.helloworld.entity.Park;

public class AddPark extends AppCompatActivity {
    private AddParkBinding binding;
    private ActivityCollectUtil activityCollectUtil;
    private Park newPark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddParkBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        EditText parkName = binding.addParkParkName;//获取组件
        EditText cost = binding.newParkCost;
        EditText location = binding.addParkLocation;
        Button confirm = binding.addParkConfirm;


        confirm.setOnClickListener(new View.OnClickListener() {//给button设置
            @Override
            public void onClick(View view) {
                //ToDo
                //检查是否为空，存入数据库，还应该返回给上个listview

            }
        });


    }
}