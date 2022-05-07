package com.example.helloworld;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
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

        newPark = new Park();//又一次忘了实例化！！

        confirm.setOnClickListener(new View.OnClickListener() {//给button设置
            @Override
            public void onClick(View view) {

                String newParkName = parkName.getText().toString();
                String newParkLocation = location.getText().toString();
                String newParkCost = cost.getText().toString();
                //检查是否为空
                if(newParkName.length() != 0){//小心抛出exception，对空String使用length可能出问题
                    if(newParkLocation.length() != 0){
                        if(checkCost(newParkCost)){
                            //存入数据库
                            newPark.setPark_name(newParkName);
                            newPark.setLocation(newParkLocation);
                            newPark.setCost(Float.valueOf(newParkCost));
                            newPark.save();//直接存入数据库
                            Toast.makeText(AddPark.this,"Add new park success",Toast.LENGTH_SHORT).show();

//                            Intent intent = new Intent();//返回给上个listview
//                            intent.putExtra("new_park",newPark);
//                            setResult(RESULT_OK,intent);//专门向上一个活动返回值
                            Intent intent = new Intent(AddPark.this, AllPark.class);
                            startActivity(intent);
                            finish();
                        }
                    }else{
                        Toast.makeText(AddPark.this,"The park's location can not be null!",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AddPark.this,"The park's name can not be null!",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    protected boolean checkCost(String cost){
        if(cost == null || cost.length() == 0){//为了避免抛出exception
            Toast.makeText(AddPark.this,"The park's cost can not be null!",Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

}