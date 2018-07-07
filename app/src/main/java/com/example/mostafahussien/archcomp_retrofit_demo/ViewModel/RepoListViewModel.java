package com.example.mostafahussien.archcomp_retrofit_demo.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.mostafahussien.archcomp_retrofit_demo.MainApplication;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.Repo;
import com.example.mostafahussien.archcomp_retrofit_demo.Reporisitory.RepoReporisitory;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Mostafa Hussien on 04/07/2018.
 */

public class RepoListViewModel extends AndroidViewModel{

    @Inject
    RepoReporisitory repoReporisitory;

    private MediatorLiveData<List<Repo>> repoLiveData=new MediatorLiveData<>();

    public RepoListViewModel(@NonNull Application application) {
        super(application);
        ((MainApplication)application).getAppComponent().inject(this);
    }
    public void searchRepos(String userName){
        if(userName!=null){
            LiveData<List<Repo>> listLiveData=repoReporisitory.getRepos(userName);
            repoLiveData.addSource(listLiveData, new Observer<List<Repo>>() {
                @Override
                public void onChanged(@Nullable List<Repo> repos) {
                    repoLiveData.setValue(repos);
                    repoLiveData.removeSource(repoLiveData);
                }
            });
        }
    }
    public LiveData<List<Repo>> getReposLiveData(){
        return repoLiveData;
    }
}
