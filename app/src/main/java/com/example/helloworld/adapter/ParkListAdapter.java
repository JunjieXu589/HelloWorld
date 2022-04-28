package com.example.helloworld.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.helloworld.R;
import com.example.helloworld.entity.Park;

import java.util.List;

public class ParkListAdapter extends ArrayAdapter<Park> {//This class is used to provide adapter functionality to the listview,
    // so that the page can display all the park in the form of a list

    private int resourceId;//子布局的Id，即子布局all_park_item.xml的ID
    private Context context;//Used to store the corresponding activity

    public ParkListAdapter(Context context, int textViewResourceId, List<Park> object){//constructor
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;
        this.context= context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Park onePark = getItem(position);
        View view;

        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view = convertView;
        }

        TextView parkName =(TextView) view.findViewById(R.id.parkList_parkName);//获取控件
        parkName.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);//设置其字体为斜体
        TextView location = (TextView) view.findViewById(R.id.parklist_location);//获取控件
        TextView cost = (TextView) view.findViewById(R.id.parklist_cost);//获取控件
        parkName.setText(onePark.getPark_name());//赋值
        location.setText(onePark.getLocation());
        cost.setText(String.valueOf(onePark.getCost()));//转划成String才能显示


       return view;
    }
}
