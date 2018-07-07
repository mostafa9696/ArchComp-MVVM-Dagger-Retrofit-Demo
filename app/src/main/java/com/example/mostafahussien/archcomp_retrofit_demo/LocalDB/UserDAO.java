package com.example.mostafahussien.archcomp_retrofit_demo.LocalDB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.UserLocal;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserLocal user);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Query("SELECT * from user_table WHERE login LIKE :login")
    LiveData<UserLocal> getUser(String login);
}
