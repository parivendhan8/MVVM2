package com.example.mvvm_sample2;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mvvm_sample2.R;
import com.example.mvvm_sample2.databinding.ListActivityBinding;
import com.example.mvvm_sample2.presenter.ListVModel;

public class ListActivity extends AppCompatActivity  {

    ListActivityBinding binding;
    ListVModel vModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.list_activity);
        vModel = ViewModelProviders.of(this).get(ListVModel.class);
        binding.setLifecycleOwner(this);
        binding.setListModel(vModel);


    }
}
