package com.example.helloworld;

import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.adapter.BlackListAdapter;
import com.example.helloworld.databinding.BlackListBinding;
import com.example.helloworld.entity.Park;

import java.util.ArrayList;
import java.util.List;


public class BlackList extends AppCompatActivity {

    private BlackListBinding binding;
    private List<Park> parklist = new ArrayList<>();//就是存储所有blacklist里的park的数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.black_list);
        binding = BlackListBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        initBlacklist();//初始化测试数据
        BlackListAdapter blackListAdapter = new BlackListAdapter(BlackList.this,R.layout.black_list_item,parklist);

        ListView listview = binding.blacklistListview;
        listview.setAdapter(blackListAdapter);
    }


    private void initBlacklist(){
        for(int i=0; i<2 ; i++){
            Park a = new Park("Beijing Haidian public park","Beijing Haidian,China",0);
            parklist.add(a);
            Park b = new Park("Beijing Chaoyang public park","Beijing Chaoyang,China",1);
            parklist.add(b);
            Park c = new Park("Beijing Jingjiang Hotel park","Beijing Haidian,China",1);
            parklist.add(c);
            Park d = new Park("BNU school park","Beijing Haidian,China",0);
            parklist.add(d);
            Park e = new Park("BUPT underground park","Beijing Haidian,China",1);
            parklist.add(e);
        }



    }
}