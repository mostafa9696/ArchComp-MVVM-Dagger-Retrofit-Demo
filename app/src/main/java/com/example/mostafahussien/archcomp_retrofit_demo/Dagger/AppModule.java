package com.example.mostafahussien.archcomp_retrofit_demo.Dagger;

import android.app.Application;
import android.content.Context;

import com.example.mostafahussien.archcomp_retrofit_demo.Network.GithubAPI;
import com.example.mostafahussien.archcomp_retrofit_demo.Network.RepoRepositoryNetwork;
import com.example.mostafahussien.archcomp_retrofit_demo.Reporisitory.RepoReporisitory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

@Module(includes = RoomModule.class)
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context providesAppContext(){
        return application;
    }

    @Provides
    @Singleton
    public GithubAPI providesGithubApi(){       // provide dependency for UserRepositoryNetwork
        return new Retrofit.Builder()
                .baseUrl(GithubAPI.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubAPI.class);
    }

    @Provides
    @Singleton
    public RepoReporisitory providesGithubRepository(GithubAPI githubAPI) {
        return new RepoRepositoryNetwork(githubAPI);
    }
}
