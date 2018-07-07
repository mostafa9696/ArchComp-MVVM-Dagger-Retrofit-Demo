package com.example.mostafahussien.archcomp_retrofit_demo;

import android.app.Application;

import com.example.mostafahussien.archcomp_retrofit_demo.Dagger.AppComponent;
import com.example.mostafahussien.archcomp_retrofit_demo.Dagger.AppModule;
import com.example.mostafahussien.archcomp_retrofit_demo.Dagger.DaggerAppComponent;
import com.example.mostafahussien.archcomp_retrofit_demo.Dagger.RoomModule;
import com.example.mostafahussien.archcomp_retrofit_demo.LocalDB.UserDAO;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.UserLocal;

import javax.inject.Inject;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public class MainApplication extends Application {
    AppComponent appComponent;

    @Inject
    UserDAO userDAO;

    @Override
    public void onCreate() {
        super.onCreate();
        
        appComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .roomModule(new RoomModule(this))
                .build();

        appComponent.inject(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //called first time created
                userDAO.deleteAll();
                userDAO.insert(new UserLocal("kevin", "kévin", ""));
                userDAO.insert(new UserLocal("florent37", "flo", ""));
            }
        }).start();
    }
    public AppComponent getAppComponent(){
        return appComponent;
    }
}
