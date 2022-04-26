package com.example.helloworld.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.helloworld.R;
import com.example.helloworld.databinding.BlackListItemBinding;
import com.example.helloworld.entity.Park;
import com.example.helloworld.entity.RecordItem;
import java.util.List;

public class BlackListAdapter extends ArrayAdapter<Park> {
    private int resourceId;//子布局的Id，即子布局black_list_item.xml的ID
    private Context context;//用于存放对应的activity


    public BlackListAdapter(Context context, int textViewResourceId, List<Park> object){
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;
        this.context= context;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        Park oneBlackListPark = getItem(position);
        View view;

        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view = convertView;
        }

        TextView parkName =(TextView) view.findViewById(R.id.blackList_parkName);//获取控件
        parkName.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);//设置其字体为斜体
        TextView location = (TextView) view.findViewById(R.id.blacklist_location);
        TextView cost = (TextView) view.findViewById(R.id.blacklist_cost);
        parkName.setText(oneBlackListPark.getPark_name());//赋值
        location.setText(oneBlackListPark.getLocation());
        cost.setText(String.valueOf(oneBlackListPark.getCost()));//转划成String才能显示
        return view;
    }
}
