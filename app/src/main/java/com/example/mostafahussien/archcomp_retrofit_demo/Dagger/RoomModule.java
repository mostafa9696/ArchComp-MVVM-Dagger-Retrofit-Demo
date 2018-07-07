package com.example.mostafahussien.archcomp_retrofit_demo.Dagger;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.mostafahussien.archcomp_retrofit_demo.LocalDB.UserDAO;
import com.example.mostafahussien.archcomp_retrofit_demo.LocalDB.UserRoomDatabase;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

@Module
public class RoomModule {

    private final UserRoomDatabase roomDatabase;

    public RoomModule(Application application){
        roomDatabase= Room.databaseBuilder(application,UserRoomDatabase.class,"user_db").build();
    }

    @Provides
    @Singleton
    public UserRoomDatabase providesUserRoomDatabase(Context context){      // provide it because DAO use it
        return roomDatabase;
    }

    @Singleton
    @Provides
    public UserDAO providesUserDAO(UserRoomDatabase userRoomDatabase){      // provide dependency for UserRepositoryLocal
        return userRoomDatabase.userDao();
    }
}
