package com.example.mostafahussien.archcomp_retrofit_demo.Network;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.User;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.UserNetwork;
import com.example.mostafahussien.archcomp_retrofit_demo.Reporisitory.UserReporistory;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public class UserRepositoryNetwork implements UserReporistory {

    private final GithubAPI githubAPI;

    @Inject
    public UserRepositoryNetwork(GithubAPI githubAPI) {
        this.githubAPI = githubAPI;
    }

    @Override
    public LiveData<User> searchUser(String name) {

        final MutableLiveData<UserNetwork> liveData = new MutableLiveData<>();

        githubAPI.user(name).enqueue(new Callback<UserNetwork>() {
            @Override
            public void onResponse(Call<UserNetwork> call, Response<UserNetwork> response) {
                if(response.isSuccessful()) {
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserNetwork> call, Throwable t) {

            }
        });

        return Transformations.map(liveData, new Function<UserNetwork, User>() {
            @Override
            public User apply(UserNetwork input) {  // map UserNetwork object to User object
                return input.toUser();
            }
        });
    }
}
