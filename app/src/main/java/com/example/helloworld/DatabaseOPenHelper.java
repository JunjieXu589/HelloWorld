package com.example.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseOPenHelper extends SQLiteOpenHelper {//未使用LitePal写的，已经弃用

    public static final String CREATE_USER ="create table user ("
            + "user_id text primary key, "
            + "password text, "
            + "car text, "
            + "payment text, "
            + "balance real, "
            + "telephone text)";

    private Context mContext;
    public DatabaseOPenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        Toast.makeText(mContext, "创建成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


}
