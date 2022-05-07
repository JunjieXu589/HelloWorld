package com.example.helloworld;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import com.example.helloworld.databinding.AddRecordBinding;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.entity.Park;
import com.example.helloworld.entity.Record;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddRecord extends AppCompatActivity {
    private AddRecordBinding binding;
    private List<String> parkNameList;//这是spinner用的那个list
    private ArrayAdapter<String> parkNameAdapter;
    private Calendar calendar;
    private Park chosenPark;//这是那个被选中的park 即record要包含的那个park
    private Record newRecord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddRecordBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);//get the binding class
//        setContentView(R.layout.add_record);//The effect should be consistent with the code above

        Spinner parkNameSpinner = binding.addRecordParkName;//获取页面组件
        Button more = binding.addMorePark;
        Button confirm = binding.addRecordConfirm;
        EditText date = binding.addDate;
        EditText time = binding.addTime;
        EditText useEasy = binding.detailEasyUse;
        EditText reputation =binding.detailReputation;
        EditText comment = binding.addComment;



        chosenPark = new Park();//牢记初始化！这个是记录选择的是哪个park
        newRecord = new Record();////牢记初始化！这个是要以俺家到数据库中的record
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


        calendar = Calendar.getInstance();// calender的实列,表示当前日期的实例
        date.setInputType(InputType.TYPE_NULL);//这样设置可以使其不弹出小键盘，但需要点击两次才会弹datePicker
        date.setText(calendar.get(Calendar.YEAR)+"-"
                +(calendar.get(Calendar.MONTH)+1)+"-"
                +calendar.get(Calendar.DAY_OF_MONTH));//很奇怪，月份是从零开始的，必须加1
                                                      //为date选择框设置默认时间，默认为当前时间
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddRecord.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

            }
        });


        time.setInputType(InputType.TYPE_NULL);//设置可以使其不弹出小键盘
        time.setText(calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE));//自动填充当前时间
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddRecord.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                        time.setText(hour+":"+minute);
                    }
                }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),true);
                timePickerDialog.show();

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
                //存入数据库
                String inputUseEasy = useEasy.getText().toString();
                String inputReputation = reputation.getText().toString();
                String inputTime = date.getText().toString()+" "+time.getText().toString();
                String inputComment = comment.getText().toString();//获取String值
                Log.e("Test", chosenPark.getLocation());//测试是否可以正确获得

                Customer me =  LitePal.findFirst(Customer.class);//直接搜索了第一个
                newRecord.setPark(chosenPark);
                newRecord.setCustomer(me);
                newRecord.setUse_easy(inputUseEasy);
                newRecord.setReputation(inputReputation);
                newRecord.setTime(inputTime);
                newRecord.setComment(inputComment);
                if (newRecord.save()) {
                    Toast.makeText(AddRecord.this, "Record added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddRecord.this, "Record added failed", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(AddRecord.this, HomePage.class);
                startActivity(intent);//直接跳转回主页

            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//当从allpark返回时会调用这个方法
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK){

                   //
                    int position = data.getIntExtra("park_position",0);

                    Spinner parkSpinner = findViewById(R.id.add_record_parkName);
                    chosenPark = LitePal.find(Park.class,(position+1));
                    Toast.makeText(AddRecord.this,"You have chosen a park",Toast.LENGTH_SHORT).show();
                    parkNameList.add(0,chosenPark.getPark_name());

                    parkSpinner.setAdapter(parkNameAdapter);//重设适配器
                    parkNameAdapter.notifyDataSetChanged();
                    parkSpinner.setSelection(0,true);//true表示立刻刷新spinner的选择


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