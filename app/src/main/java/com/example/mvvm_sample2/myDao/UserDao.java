package com.example.mvvm_sample2.myDao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from users")
    List<UserData> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserData... entity);

    @Delete
    void Delete(UserData entity);

    @Update
    void update(UserData entity);

}
