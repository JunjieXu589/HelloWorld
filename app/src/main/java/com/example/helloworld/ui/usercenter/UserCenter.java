package com.example.helloworld.ui.usercenter;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.helloworld.R;
import com.example.helloworld.databinding.UserCenterFragmentBinding;

public class UserCenter extends Fragment {

    private UserCenterViewModel mViewModel;
    private UserCenterFragmentBinding binding;

    public static UserCenter newInstance() {
        return new UserCenter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UserCenterFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();





        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserCenterViewModel.class);
        // TODO: Use the ViewModel
    }

}