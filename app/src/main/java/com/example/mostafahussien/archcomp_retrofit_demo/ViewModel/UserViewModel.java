package com.example.mostafahussien.archcomp_retrofit_demo.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.mostafahussien.archcomp_retrofit_demo.LocalDB.UserRepositoryLocal;
import com.example.mostafahussien.archcomp_retrofit_demo.MainApplication;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.User;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.UserSearchResult;
import com.example.mostafahussien.archcomp_retrofit_demo.Network.UserRepositoryNetwork;
import com.example.mostafahussien.archcomp_retrofit_demo.Reporisitory.RepoReporisitory;

import javax.inject.Inject;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public class UserViewModel extends AndroidViewModel {


    @Inject
    UserRepositoryNetwork repositoryNetwork;
    @Inject
    UserRepositoryLocal repositoryLocal;

    private final MediatorLiveData<UserSearchResult> userLiveData = new MediatorLiveData<>();


    public UserViewModel(@NonNull Application application) {
        super(application);
        ((MainApplication) application).getAppComponent().inject(this);
    }

    public void serachOnline(@Nullable final String userName){
        if(userName!=null){
            final LiveData<User> userLiveDataNetwork=repositoryNetwork.searchUser(userName);
            userLiveData.addSource(userLiveDataNetwork, new Observer<User>() {
                @Override
                public void onChanged(@Nullable User user) {
                    userLiveData.postValue(new UserSearchResult(user));
                    userLiveData.removeSource(userLiveDataNetwork);
                }
            });
        }
    }
    public void searchLocally(@Nullable final String userName) {
        if (userName != null) {
            //userLiveData will be notified when the user is fetched
            final LiveData<User> userLiveDataLocal = repositoryLocal.searchUser(userName);
            userLiveData.addSource(userLiveDataLocal, new Observer<User>() {
                @Override
                public void onChanged(@Nullable User user) {
                    userLiveData.postValue(new UserSearchResult(user));
                    userLiveData.removeSource(userLiveDataLocal);
                }
            });
        }
    }

    public LiveData<UserSearchResult> getUserLiveData() {
        return userLiveData;
    }

}
