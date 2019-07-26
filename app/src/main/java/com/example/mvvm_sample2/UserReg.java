package com.example.mvvm_sample2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.mvvm_sample2.myDao.UserData;
import com.example.mvvm_sample2.databinding.UserRegisterationBinding;
import com.example.mvvm_sample2.presenter.UserModel;

import java.util.List;

public class UserReg extends AppCompatActivity {

    private static final String TAG = "UserReg";

    UserRegisterationBinding binding;
    UserModel userModel;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registeration);
        getSupportActionBar().hide();

        binding = DataBindingUtil.setContentView(UserReg.this, R.layout.user_registeration);
        userModel = ViewModelProviders.of(UserReg.this).get(UserModel.class);
        binding.setLifecycleOwner(this);
        binding.setUserModel(userModel);

        Cursor query = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null);

        while (query.moveToNext())
        {
            String string = query.getString(query.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            Log.d(TAG, "onCreate: " + string );
        }

        userModel.getAllList().observe(UserReg.this, new Observer<List<UserData>>() {
            @Override
            public void onChanged(@Nullable List<UserData> userEntities) {

//                Log.d("userEntities_list", userEntities.get(userEntities.size() - 1).getFirst_name());

//                Toast.makeText(UserReg.this, " " + userEntities.get(userEntities.size() - 1).getFirst_name() , Toast.LENGTH_LONG).show();

                binding.setCustomAdapter(new CustomAdapter(userEntities));

//                binding.recyclerView.setLayoutManager(new LinearLayoutManager(UserReg.this));
//                binding.recyclerView.setHasFixedSize(true);
//                binding.recyclerView.setAdapter();
            }
        });

    }

    public void Payment(View view) {

//        CheckoutController.startPayment(UserReg.this, new CheckoutSetupParametersHandler() {
//            @Override
//            public void onRequestPaymentSession(@NonNull CheckoutSetupParameters checkoutSetupParameters) {

    }

//    public void save(View view) {
//
////        new UserModel("Praveen", "Kumar", "9042298545");
//
//
//        UserData userEntit = new UserData();
//        userEntit.setFirst_name("Praveen");
//        userEntit.setLast_name("Kumar");
//        userEntit.setPhone("9042298545");
//
//        DatabaseClient.getInstance(getApplicationContext())
//                .getAppDatabse()
//                .userDao()
//                .insert(userEntit);
//
//        List<UserData> all = DatabaseClient.getInstance(getApplicationContext())
//                .getAppDatabse()
//                .userDao().getAll();
//
//        Log.d("UserEntity_all", all + "");
//    }
//

}
