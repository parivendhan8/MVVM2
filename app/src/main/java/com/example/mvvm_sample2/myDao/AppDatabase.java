package com.example.mvvm_sample2.myDao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = UserData.class, version = 4, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDao userDao();

   }
