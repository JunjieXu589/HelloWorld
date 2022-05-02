package com.example.helloworld;

import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import com.example.helloworld.databinding.AddRecordBinding;

import java.util.ArrayList;
import java.util.List;

public class AddRecord extends AppCompatActivity {
    private AddRecordBinding binding;
    private List<String> parkNameList;
    private ArrayAdapter<String> parkNameAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AddRecordBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);//get the binding class
//        setContentView(R.layout.add_record);//The effect should be consistent with the code above

        Spinner parkNameSpinner = binding.addRecordParkName;
        Button more = binding.addMorePark;//获取页面组件
        Button confirm = binding.addRecordConfirm;


        parkNameList = new ArrayList<String>();
        initParkNameList();


        parkNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, parkNameList);
        parkNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//设置下拉表的样式
        parkNameSpinner.setAdapter(parkNameAdapter);//设置adapter

        parkNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {//一般用于没有选项的情况，这种情况很少发生

            }
        });



        more.setOnClickListener(new View.OnClickListener() {//button展示数据库里所有的park，并等用户选择后返回position值
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecord.this, AllPark.class);
                startActivityForResult(intent,1);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecord.this, AllPark.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//当从allpark返回时会调用这个方法
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK){

                   //TODO
                    int position = data.getIntExtra("park_position",0);
                    Log.e("Test",String.valueOf(position));
                }
            break;
            default:
        }
    }



    public void initParkNameList(){
        parkNameList.add("BUPT school park");
        parkNameList.add("QMUL school park");
        parkNameList.add("BUPT underground park");

    }
}