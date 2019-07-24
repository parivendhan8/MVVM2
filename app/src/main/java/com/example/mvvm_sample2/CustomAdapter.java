package com.example.mvvm_sample2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.example.mvvm_sample2.myDao.UserData;
import com.example.mvvm_sample2.databinding.ChildItemsBinding;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    List<UserData> list = new ArrayList<UserData>();

    public CustomAdapter(List<UserData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ChildItemsBinding binding = ChildItemsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_items, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        UserData entity = list.get(i);
        myViewHolder.setBinding(entity);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ChildItemsBinding binding;

        @SuppressLint("ClickableViewAccessibility")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            this.binding = itemView;
            binding = DataBindingUtil.bind(itemView);

            binding.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final LinearLayout view = binding.parentLayout;



                    view.animate()
                            .setDuration(600)
                            .alpha(0.7f)
                            .scaleX(0.8f)
                            .scaleY(0.8f)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    view.animate()
                                            .setDuration(100)
                                            .alpha(1f)
                                            .scaleX(1)
                                            .scaleY(1f);

                                }

                            } )
                    ;




                }
            });


            binding.parentLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {







//                    if (event.getAction() == MotionEvent.ACTION_DOWN)
//                    {
//
//                    }
//
//                    if (event.getAction() == MotionEvent.ACTION_MOVE)
//                    {
//                        view.animate()
//                                .setDuration(600)
//                                .alpha(1)
//                                .scaleX(1)
//                                .scaleY(1);
//                    }
//


                    return false;
                }
            });


        }

        public void setBinding(UserData model)
        {
            binding.setUserDataModel(model);
        }
    }
}
