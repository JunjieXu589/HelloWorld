package com.example.helloworld.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.helloworld.entity.Customer;
import org.litepal.LitePal;

import java.util.List;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        List<Customer> allCustomer = LitePal.findAll(Customer.class);
        if(!allCustomer.isEmpty()){
        mText.setValue("成功");}

    }

    public LiveData<String> getText() {
        return mText;
    }
}