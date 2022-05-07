package com.example.helloworld.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.helloworld.AddRecord;
import com.example.helloworld.R;
import com.example.helloworld.databinding.FragmentHomeBinding;
import com.example.helloworld.entity.Park;
import com.example.helloworld.entity.Record;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import org.litepal.LitePal;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private ExtendedFloatingActionButton addRecord;
    private Park thePark;
    private Record theRecord;

    private TextView parkName;//这是cardview里面的所有组件
    private TextView time;
    private TextView location;
    private TextView cost;
    private TextView reputation;
    private TextView easyToUse;
    private TextView comment;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        thePark = new Park();//实例化并从数据库读取这一次record的数据
        theRecord = new Record();
        theRecord = LitePal.findLast(Record.class,true);//设置激进查询为true
        thePark = theRecord.getPark();
        //Log.e("Test",thePark.getPark_name());//测试成功

        //接下来给card里面的赋值
        parkName = binding.recordParkName;
        cost = binding.detailCost;
        location = binding.detailLocation;
        time = binding.detailTime;
        reputation = binding.detailReputation;
        easyToUse = binding.detailEasyUse;
        comment = binding.detailComment;
        parkName.setText(thePark.getPark_name());
        cost.setText(String.valueOf(thePark.getCost()));
        location.setText(thePark.getLocation());
        time.setText(theRecord.getTime());
        reputation.setText(theRecord.getReputation());
        easyToUse.setText(theRecord.getUse_easy());
        comment.setText(theRecord.getComment());


        addRecord = binding.homeAddRecord;//添加record的悬浮按钮，设置点击事件
        addRecord.setOnClickListener(new View.OnClickListener() {//给floating button设置
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(getActivity(), AddRecord.class);
               startActivity(intent);
            }
        });

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}