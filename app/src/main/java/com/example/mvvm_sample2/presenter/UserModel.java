package com.example.mvvm_sample2.presenter;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.example.mvvm_sample2.ListActivity;
import com.example.mvvm_sample2.UserReg;
import com.example.mvvm_sample2.myDao.DatabaseClient;
import com.example.mvvm_sample2.myDao.UserData;

import java.util.List;

public class UserModel extends CustomModel {

    Context context;
    public MutableLiveData<String> first_name = new MutableLiveData<>();
    public MutableLiveData<String> last_name = new MutableLiveData<>();
    public MutableLiveData<List<UserData>> list = new MutableLiveData<>();

    public MutableLiveData<String> phone_no = new MutableLiveData<>();

    public UserModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }


    public  MutableLiveData<List<UserData>> getAllList()
    {
        if (list.getValue() == null)
        {
            list.setValue(DatabaseClient.getInstance(context)
                    .getAppDatabse()
                    .userDao().getAll());
        }

        return list;
    }


    public void save(View view)
    {
        Log.d("userModel ", first_name.getValue() + "");

        UserData userData = new UserData();
        userData.setFirst_name(first_name.getValue());
        userData.setLast_name(last_name.getValue());
        userData.setPhone(phone_no.getValue());


        DatabaseClient.getInstance(context).getAppDatabse()
                .userDao().insert(userData);

        List<UserData> all = DatabaseClient.getInstance(context)
                .getAppDatabse()
                .userDao()
                .getAll()
                ;

        list.setValue(all);

//        ListVModel vModel = new ListVModel(getApplication());
//        vModel.textviewData.setValue(first_name.getValue());
//
//        getApplication().startActivity(new Intent(getApplication().getApplicationContext(), ListActivity.class));

    }






}


