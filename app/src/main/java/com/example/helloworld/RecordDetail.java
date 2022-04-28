package com.example.helloworld;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.databinding.RecordDetailBinding;

public class RecordDetail extends AppCompatActivity {
    private RecordDetailBinding binding;
    private int recordPosition;
    private static ActivityCollectUtil activityCollectUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_detail);

        activityCollectUtil = new ActivityCollectUtil();
        activityCollectUtil.addActivity(this);//this keyword is used to point to the object that calls it, the intrinsic activity

        Intent intent = getIntent();
        recordPosition = intent.getIntExtra("record_position",0);//注意数字是从0开始的

        String s = String.valueOf(recordPosition);
        Toast.makeText(RecordDetail.this,s,Toast.LENGTH_SHORT).show();

        //需要从数据库读取
    }
}