package com.example.helloworld.ui.parkhistory;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.helloworld.R;
import com.example.helloworld.databinding.ParkHistoryFragmentBinding;

public class ParkHistoryFragment extends Fragment {

    private ParkHistoryViewModel mViewModel;
    private ParkHistoryFragmentBinding binding;
    private String[] data = {"aaa","bbb","ccc","ddd","eee","fff","ggg","hhh","iii","kkk","jjj"};

    public static ParkHistoryFragment newInstance() {
        return new ParkHistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ParkHistoryFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();//函数最后，返回根视图


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1,data);
        ListView listView = binding.listView;
        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ParkHistoryViewModel.class);
        // TODO: Use the ViewModel
    }

}