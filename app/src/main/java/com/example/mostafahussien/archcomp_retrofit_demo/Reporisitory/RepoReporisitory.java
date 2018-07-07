package com.example.mostafahussien.archcomp_retrofit_demo.Reporisitory;

import android.arch.lifecycle.LiveData;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.Repo;

import java.util.List;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public interface RepoReporisitory {
    LiveData<List<Repo>> getRepos(String userName);
}
