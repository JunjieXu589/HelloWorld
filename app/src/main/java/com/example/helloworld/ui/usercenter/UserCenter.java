package com.example.helloworld.ui.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.helloworld.*;
import com.example.helloworld.databinding.UserCenterFragmentBinding;
import com.example.helloworld.entity.Session;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class UserCenter extends Fragment {


    private UserCenterViewModel mViewModel;
    private UserCenterFragmentBinding binding;
    static Session session;
    private  ActivityCollectUtil activityCollectUtil;

    public static UserCenter newInstance() {
        return new UserCenter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UserCenterFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        ImageView profileBackground = binding.headBack;
        ImageView profileImage = binding.imagesHead;//使用glide设置头像比较方便
        Glide.with(getActivity())
                .load(R.drawable.profile_1)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(4,25)))
                .apply(RequestOptions.centerCropTransform())
                .into(profileBackground);
        Glide.with(getActivity())
                .load(R.drawable.profile_car)
                .apply(RequestOptions.circleCropTransform())
                .into(profileImage);



        TextView account = binding.userCenterAccount;
        session =new Session();
        account.setText(session.getUserID());//在此之前千万别忘记初始化session！！！
        account.setOnClickListener(new View.OnClickListener() {//给用户名现实的位置设置监听器
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ModifyInfo.class);
                startActivity(intent);
            }
        });


        TextView wallet = binding.wallet;
        wallet.setOnClickListener(new View.OnClickListener() {//给Wallet设置监听器，跳转到balance.xml
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Wallet.class);
                startActivityForResult(intent,2);
            }
        });

        TextView blacklist = binding.blacklist;
        blacklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), BlackList.class);
                startActivityForResult(intent,3);
            }
        });


        TextView privacyandPolicy = binding.privacy;
        privacyandPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Privacy.class);
                startActivityForResult(intent,3);
            }
        });


        //Logout 按钮
        Button logout = binding.btnLogout;
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityCollectUtil.finishAllActivity();//结束所有栈里的activity

                Intent intent = new Intent(getActivity(), MainActivity.class);//跳转到登录界面
                startActivityForResult(intent,4);
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