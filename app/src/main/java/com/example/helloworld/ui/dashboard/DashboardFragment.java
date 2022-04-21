package com.example.helloworld.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.helloworld.R;
import com.example.helloworld.databinding.FragmentDashboardBinding;
import com.example.helloworld.entity.Customer;
import org.litepal.LitePal;

import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private String[] data = {"aaa","bbb","ccc","ddd","eee","fff","ggg","hhh","iii","kkk","jjj"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        dashboardViewModel =
//                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1,data);
        ListView listView = binding.listView;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//给listview里的每一个item设置了点击事件
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getActivity(),"成功",Toast.LENGTH_SHORT).show();
            }
        });

        //        final TextView textView = binding.textDashboard;//获取layout里的对应组件
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        List<Customer> allCustomer = LitePal.findAll(Customer.class);//测试
//        Boolean a = allCustomer.isEmpty();//测试
//        Button button = binding.testDashboard;//测试
//        button.setOnClickListener( new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                if(a == false){
//                textView.setText("abssd");}
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