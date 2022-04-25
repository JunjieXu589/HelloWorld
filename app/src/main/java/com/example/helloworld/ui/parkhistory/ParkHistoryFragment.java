package com.example.helloworld.ui.parkhistory;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.helloworld.Privacy;
import com.example.helloworld.R;
import com.example.helloworld.Register;
import com.example.helloworld.adapter.RecordItemAdapter;
import com.example.helloworld.databinding.ParkHistoryFragmentBinding;
import com.example.helloworld.entity.RecordItem;

import java.util.ArrayList;
import java.util.List;

public class ParkHistoryFragment extends Fragment {

    private ParkHistoryViewModel mViewModel;
    private ParkHistoryFragmentBinding binding;
    private List<RecordItem> recordList= new ArrayList<>();

    public static ParkHistoryFragment newInstance() {
        return new ParkHistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ParkHistoryFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();//函数最后，返回根视图

        initRecord();//填入数据
        RecordItemAdapter adapter = new RecordItemAdapter(getActivity(), R.layout.record_item, recordList);
        ListView listView = binding.listView;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setMessage("确定删除?");
                builder.setTitle("Hint");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(),"Delete successful",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("cancel", null);
                builder.create().show();


            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                recordList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getActivity(),"长按删除",Toast.LENGTH_SHORT).show();

                return false;
            }
        });



        return root;
    }

    private void initRecord(){
        for(int i=0; i<2; i++){
            RecordItem aaa = new RecordItem("BUPT School Park","2022-01-23 12:00");
            recordList.add(aaa);
            RecordItem bbb = new RecordItem("BUPT School Park","2022-01-25 12:00");
            recordList.add(bbb);
            RecordItem ccc = new RecordItem("Beijing International Park","2022-01-25 16:00");
            recordList.add(ccc);
            RecordItem ddd = new RecordItem("Beijing International Park","2022-01-25 16:00");
            recordList.add(ddd);
            RecordItem eee = new RecordItem("QMUL School park","2022-02-04 08:00");
            recordList.add(eee);
            RecordItem fff = new RecordItem("QMUL School park","2022-02-07 09:00");
            recordList.add(fff);
        }

    }





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ParkHistoryViewModel.class);
        // TODO: Use the ViewModel
    }

}