package com.example.mvvm_sample2.presenter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class CustomModel<V> extends AndroidViewModel {

    V view;

    public CustomModel(@NonNull Application application) {
        super(application);

    }

    public V getView()
    {
        return view;
    }



}
