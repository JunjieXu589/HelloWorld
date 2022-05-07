package com.example.helloworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.adapter.BlackListAdapter;
import com.example.helloworld.adapter.ParkListAdapter;
import com.example.helloworld.databinding.AllParkBinding;
import com.example.helloworld.entity.Blacklist;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.entity.Park;
import com.example.helloworld.entity.Session;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class AllPark extends AppCompatActivity {

    private AllParkBinding binding;
    private List<Park> parklist = new ArrayList<>();//就是存储数据库所有park的数组
    private ActivityCollectUtil activityCollectUtil;
    private ParkListAdapter parkListAdapter;
    private Blacklist blackListPark;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AllParkBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);//get binding class

          //there is no need to invoke this method because this activity will be destroyed after clickListener
//        activityCollectUtil = new ActivityCollectUtil();
//        activityCollectUtil.addActivity(this);//"this" keyword is used to point to the object that invokes it


        //initParklist();//要初始化测试数据
        parklist = LitePal.findAll(Park.class);
        parkListAdapter = new ParkListAdapter(AllPark.this,R.layout.all_park_item, parklist);



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

//        blackListPark =new Blacklist();//千万别忘记实例化
//        session = new Session();
//        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {//长按
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                AlertDialog.Builder builder=new AlertDialog.Builder(AllPark.this);
//                builder.setMessage("Add this park to the blacklist?");
//                builder.setTitle("Hint");
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        //LitePal.where("userID = ?",session.getUserID()).find(Customer.class);//查出来是list
//                        blackListPark.setCustomer(session.getCustomer());
//                        blackListPark.setPark(parklist.get(position));
//                        blackListPark.save();
//
//                        parklist.remove(position);
//                        parkListAdapter.notifyDataSetChanged();//刷新UI
//
//                    }
//                });
//                builder.setNegativeButton("cancel", null);//negative按钮，do nothing
//                builder.create().show();
//
//                return false;
//            }
//        });


        ExtendedFloatingActionButton addNewPark =binding.addPark;
        addNewPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllPark.this, AddPark.class);
                startActivityForResult(intent,1);
                finish();

            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        switch(requestCode) {
//            case 1:
//                if(resultCode == RESULT_OK){
//                    //TODO
//                    Park newPark = (Park) getIntent().getSerializableExtra("new_park");
//                    Log.e("Test",newPark.getPark_name());
//
//                    parklist.add(newPark);
//                    parkListAdapter.notifyDataSetChanged();
//                }
//        }
//    }



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
            Park d = new Park("BNU school park", "Beijing Haidian,China", 1);
            parklist.add(d);

        }
    }
}