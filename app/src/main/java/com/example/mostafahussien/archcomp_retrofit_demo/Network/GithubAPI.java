package com.example.mostafahussien.archcomp_retrofit_demo.Network;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.Repo;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.UserNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public interface GithubAPI {
    String URL = "https://api.github.com/";

    @GET("/users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("/users/{user}")
    Call<UserNetwork> user(@Path("user") String user);
}
