package com.example.helloworld;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

        binding = AddRecordBinding.inflate(getLayoutInflater());//获取绑定类
        setContentView(R.layout.add_record);

        Spinner parkNameSpinner = binding.addRecordParkName;
        Button more = binding.addMorePark;//获取页面组件

        parkNameList = new ArrayList<String>();
        parkNameList.add("BUPT school park");
        parkNameList.add("QMUL school park");
        parkNameList.add("BUPT underground park");

        parkNameAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,parkNameList);
        parkNameAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        parkNameSpinner.setAdapter(parkNameAdapter);//设置adapter

        parkNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    public void initParkNameList(){
        parkNameList.add("BUPT school park");
        parkNameList.add("QMUL school park");
        parkNameList.add("BUPT underground park");

    }
}