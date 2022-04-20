package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Privacy extends AppCompatActivity {

    private ActivityCollectUtil activityCollectUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy);

        activityCollectUtil = new ActivityCollectUtil();
        activityCollectUtil.addActivity(this);//this关键字用于指向调用它的对象，即本activity
    }
}