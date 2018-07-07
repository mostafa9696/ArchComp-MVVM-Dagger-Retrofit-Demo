package com.example.mostafahussien.archcomp_retrofit_demo.Dagger;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.mostafahussien.archcomp_retrofit_demo.MainApplication;
import com.example.mostafahussien.archcomp_retrofit_demo.MainFragment;
import com.example.mostafahussien.archcomp_retrofit_demo.ViewModel.RepoListViewModel;
import com.example.mostafahussien.archcomp_retrofit_demo.ViewModel.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

@Component(modules = AppModule.class)
@Singleton
public abstract class AppComponent {
    public static AppComponent from(@NonNull Context context){
        return ((MainApplication) context.getApplicationContext()).getAppComponent();
    }

    // classes that has objects that need dependencies

    public abstract void inject(RepoListViewModel reposListViewModel);

    public abstract void inject(UserViewModel userViewModel);

    public abstract void inject(MainApplication mainApplication);
}
