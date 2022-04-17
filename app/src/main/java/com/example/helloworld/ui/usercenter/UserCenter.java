package com.example.helloworld.ui.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.helloworld.ActivityCollectUtil;
import com.example.helloworld.MainActivity;
import com.example.helloworld.Register;
import com.example.helloworld.databinding.UserCenterFragmentBinding;
import com.example.helloworld.entity.Session;

public class UserCenter extends Fragment {


    private UserCenterViewModel mViewModel;
    private UserCenterFragmentBinding binding;
    private static Session session;
    private  ActivityCollectUtil activityCollectUtil;

    public static UserCenter newInstance() {
        return new UserCenter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UserCenterFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();






        //Logout 按钮
        Button logout = binding.btnLogout;
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityCollectUtil.finishAllActivity();//结束所有栈里的activity

                Intent intent = new Intent(getActivity(), MainActivity.class);//跳转到登录界面
                startActivityForResult(intent,1);
            }
        });



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserCenterViewModel.class);
        // TODO: Use the ViewModel
    }

}