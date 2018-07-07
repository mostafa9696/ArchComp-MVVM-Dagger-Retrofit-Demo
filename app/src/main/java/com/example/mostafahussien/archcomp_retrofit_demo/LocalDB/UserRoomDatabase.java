package com.example.mostafahussien.archcomp_retrofit_demo.LocalDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.UserLocal;

import javax.inject.Singleton;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

@Singleton
@Database(entities = {UserLocal.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase{
    public abstract UserDAO userDao();
}
