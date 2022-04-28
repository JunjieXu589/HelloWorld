package com.example.helloworld;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityCollectUtil {
    public static ArrayList<Activity> mActivityList = new ArrayList<Activity>();//must be static

    /**
     * When a activity override onCreate(), use this method
     * @param activity
     */
    public static void addActivity(Activity activity){
        //Determine whether the collection has already been added, and if it has been added, it will not be added
        if (!mActivityList.contains(activity)){
            mActivityList.add(activity);
        }
    }

    /**
     * onDestroy()时删除
     * @param activity
     */
    public static void removeActivity(Activity activity){
        mActivityList.remove(activity);
    }

    /**
     * destroy all Activity
     */
    public static void finishAllActivity(){
        for (Activity activity : mActivityList){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }


}
