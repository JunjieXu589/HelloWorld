package com.example.helloworld.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helloworld.R;
import com.example.helloworld.RecordDetail;
import com.example.helloworld.Register;
import com.example.helloworld.databinding.ParkHistoryFragmentBinding;
import com.example.helloworld.entity.RecordItem;

import java.util.List;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.startActivity;

public class RecordItemAdapter extends ArrayAdapter<RecordItem> {//extends ArrayAdapter
    private int resourceId;//似乎是子布局的Id，即子布局record_item.xml的ID
    private ParkHistoryFragmentBinding binding;
    private Context context;//用于存放对应的activity，即parkhistory这个fragment????

    public RecordItemAdapter(Context context, int textViewResourceId, List<RecordItem> object){
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;

        this.context= context;
    }



    public View getView(int position, View convertView, ViewGroup parent){
        RecordItem recordItem = getItem(position);
        View view;
        ViewHolder viewHolder;

        if(convertView == null){//convertView:Used to cache previously loaded layouts for later reuse
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
            viewHolder = (ViewHolder) view.getTag();//Re-fetch the viewHolder from the view
        }

        viewHolder.recordParkName.setText(recordItem.getParkName());//把recordItem里面的数据放到textview里
        viewHolder.recordTime.setText(recordItem.getRecordTime());//把recordItem里面的数据放到textview里

        viewHolder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//给cardview设置监听事件
               //
                Intent intent = new Intent(context, RecordDetail.class);//跳转同时传递position参数
                intent.putExtra("record_position",position);//注意position是从0开始计数的
                context.startActivity(intent);
            }
        });
        viewHolder.readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, RecordDetail.class);//跳转
//                intent.putExtra("record_position",position);//注意position是从0开始计数的
//                context.startActivity(intent);

                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setMessage("确定删除?");
                builder.setTitle("Hint");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("cancel", null);
                builder.create().show();
            }
        });


        return view;

    }

    class ViewHolder{//Inner classes
        CardView cardview;
        TextView recordParkName;
        TextView recordTime;
        Button readMore;//
        // add a ImageView?

    }


}
