package com.example.mvvm_sample2;

import android.arch.lifecycle.ViewModelProviders;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mvvm_sample2.R;
import com.example.mvvm_sample2.databinding.ListActivityBinding;
import com.example.mvvm_sample2.presenter.ListVModel;

public class ListActivity extends AppCompatActivity  {

    private static final String TAG = "ListActivity";

    ListActivityBinding binding;
    ListVModel vModel;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.list_activity);
        vModel = ViewModelProviders.of(this).get(ListVModel.class);
        binding.setLifecycleOwner(this);
        binding.setListModel(vModel);







    }
}
