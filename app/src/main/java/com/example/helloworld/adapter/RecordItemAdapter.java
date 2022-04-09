package com.example.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helloworld.R;
import com.example.helloworld.entity.RecordItem;

import java.util.List;

public class RecordItemAdapter extends ArrayAdapter<RecordItem> {//课本117页有介绍
    private int resourceId;//似乎是子布局的Id，即子布局record_item.xml的ID

    public RecordItemAdapter(Context context, int textViewResourceId, List<RecordItem> object){
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        RecordItem recordItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent,false);

        TextView recordParkName = (TextView) view.findViewById(R.id.record_parkName);//获取子项的具体控件
        TextView recordTime =  (TextView) view.findViewById(R.id.record_time);
        Button readMore = (Button) view.findViewById(R.id.button_more);
        recordParkName.setText(recordItem.getParkName());//把recordItem里面的数据放到textview里
        recordTime.setText(recordItem.getRecordTime());//把recordItem里面的数据放到textview里

        return view;

    }
}
