package com.example.mostafahussien.archcomp_retrofit_demo.Reporisitory;

import android.arch.lifecycle.LiveData;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.User;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public interface UserReporistory {
    LiveData<User> searchUser(String name);
}
