package com.example.mostafahussien.archcomp_retrofit_demo.Network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.Repo;
import com.example.mostafahussien.archcomp_retrofit_demo.Reporisitory.RepoReporisitory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public class RepoRepositoryNetwork implements RepoReporisitory {

    private final GithubAPI githubAPI;

    // try to put @Inject and remove @Provide from Appmodule
    public RepoRepositoryNetwork(GithubAPI githubAPI) {
        this.githubAPI = githubAPI;
    }

    @Override
    public LiveData<List<Repo>> getRepos(String userName) {
        final MutableLiveData<List<Repo>> liveData = new MutableLiveData<>();

        githubAPI.listRepos(userName).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if(response.isSuccessful()){
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

        return liveData;
    }
}
