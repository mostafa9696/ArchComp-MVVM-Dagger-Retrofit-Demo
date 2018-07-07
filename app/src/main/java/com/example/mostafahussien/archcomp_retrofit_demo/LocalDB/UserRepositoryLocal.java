package com.example.mostafahussien.archcomp_retrofit_demo.LocalDB;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.User;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.UserLocal;
import com.example.mostafahussien.archcomp_retrofit_demo.Reporisitory.UserReporistory;

import javax.inject.Inject;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public class UserRepositoryLocal implements UserReporistory{

    private UserDAO userDAO;
    @Inject
    public UserRepositoryLocal(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public LiveData<User> searchUser(String name) {
        // map UserLocal object to User object
        return Transformations.map(userDAO.getUser(name), new Function<UserLocal, User>() {
            @Override
            public User apply(UserLocal input) {
                if (input != null) {
                    return input.toUser();
                } else {
                    return null;
                }
            }
        });
    }
}
