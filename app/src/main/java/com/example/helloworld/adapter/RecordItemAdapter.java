package com.example.helloworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helloworld.R;
import com.example.helloworld.Register;
import com.example.helloworld.databinding.ParkHistoryFragmentBinding;
import com.example.helloworld.entity.RecordItem;

import java.util.List;

public class RecordItemAdapter extends ArrayAdapter<RecordItem> {//课本117页有介绍
    private int resourceId;//似乎是子布局的Id，即子布局record_item.xml的ID
    private ParkHistoryFragmentBinding binding;

    public RecordItemAdapter(Context context, int textViewResourceId, List<RecordItem> object){
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        RecordItem recordItem = getItem(position);
        View view;
        ViewHolder viewHolder;

        if(convertView == null){//convertView 用于将之前加载好的布局进行缓存，以方便之后重用
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,false);
            viewHolder = new ViewHolder();
            //获取控件
            viewHolder.cardview = view.findViewById(R.id.card_view);
            viewHolder.recordParkName =  view.findViewById(R.id.record_parkName);
            viewHolder.recordTime = view.findViewById(R.id.record_time);
            viewHolder.readMore = view.findViewById(R.id.button_more);

            view.setTag(viewHolder);//将viewHolder存在view中

        }else {

            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//从view中重新获取viewHolder
        }

        viewHolder.recordParkName.setText(recordItem.getParkName());//把recordItem里面的数据放到textview里
        viewHolder.recordTime.setText(recordItem.getRecordTime());//把recordItem里面的数据放到textview里

        viewHolder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"成功",Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }

    class ViewHolder{
        CardView cardview;
        TextView recordParkName;
        TextView recordTime;
        Button readMore;//
        //应该加一个ImageView的

    }


}
