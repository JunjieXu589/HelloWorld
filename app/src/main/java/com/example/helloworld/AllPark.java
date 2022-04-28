package com.example.helloworld;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.adapter.BlackListAdapter;
import com.example.helloworld.adapter.ParkListAdapter;
import com.example.helloworld.databinding.AllParkBinding;
import com.example.helloworld.databinding.BlackListBinding;
import com.example.helloworld.entity.Park;

import java.util.ArrayList;
import java.util.List;

public class AllPark extends AppCompatActivity {

    private AllParkBinding binding;
    private List<Park> parklist = new ArrayList<>();//就是存储数据库所有park的数组
    private ActivityCollectUtil activityCollectUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AllParkBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);//get binding class

          //there is no need to invoke this method because this activity will be destroyed after clickListener
//        activityCollectUtil = new ActivityCollectUtil();
//        activityCollectUtil.addActivity(this);//"this" keyword is used to point to the object that invokes it

        //TODO：要初始化测试数据
        initParklist();
        ParkListAdapter parkListAdapter = new ParkListAdapter(AllPark.this,R.layout.all_park_item, parklist);



        ListView listview = binding.parklistListview;
        listview.setAdapter(parkListAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent();
                intent.putExtra("park_position",position);
                setResult(RESULT_OK,intent);//专门向上一个活动返回值
                finish();
            }
        });



    }



    private void initParklist() {
        for (int i = 0; i < 2; i++) {
            Park f = new Park("BUPT school park", "Beijing Haidian,China", 0);
            parklist.add(f);
            Park g = new Park("QMUL school park", "London ,UK", 0);
            parklist.add(g);
            Park e = new Park("BUPT underground park", "Beijing Haidian,China", 1);
            parklist.add(e);
            Park a = new Park("Beijing Haidian public park", "Beijing Haidian,China", 0);
            parklist.add(a);
            Park b = new Park("Beijing Chaoyang public park", "Beijing Chaoyang,China", 1);
            parklist.add(b);
            Park c = new Park("Beijing 7 days Hotel park", "Beijing Haidian,China", 1);
            parklist.add(c);
            Park d = new Park("BNU school park", "Beijing Haidian,China", 0);
            parklist.add(d);

        }
    }
}