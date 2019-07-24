package com.example.mvvm_sample2.presenter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;

public class ListVModel extends AndroidViewModel {

    public MutableLiveData<String> textviewData = new MutableLiveData<>();

    Context context;

    public ListVModel(@NonNull Application application) {
        super(application);

        context = application;
    }

    public MutableLiveData<String> getTextviewData() {

        if (textviewData.getValue() == null)
        textviewData.setValue("hai");
        return textviewData;
    }
}
