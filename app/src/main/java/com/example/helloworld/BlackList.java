package com.example.helloworld;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.adapter.BlackListAdapter;
import com.example.helloworld.databinding.BlackListBinding;
import com.example.helloworld.entity.Park;

import java.util.ArrayList;
import java.util.List;


public class BlackList extends AppCompatActivity {//Display all the park in Blacklist, paired with BlacklistAdapter

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

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {

                AlertDialog.Builder builder=new AlertDialog.Builder(BlackList.this);
                builder.setMessage("Remove this from Blacklist?");
                builder.setTitle("Hint");

                builder.setPositiveButton("Remove", new DialogInterface.OnClickListener() {//设置posotive按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // TODO: Delete in database

                        parklist.remove(position);//移除要删的那个park
                        blackListAdapter.notifyDataSetChanged();
                        Toast.makeText(BlackList.this,"Remove successful",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("cancel", null);//negative按钮，do nothing
                builder.create().show();

                return false;
            }
        });


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