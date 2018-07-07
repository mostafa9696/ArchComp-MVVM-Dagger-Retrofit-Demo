package com.example.mostafahussien.archcomp_retrofit_demo;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.Repo;
import com.example.mostafahussien.archcomp_retrofit_demo.Model.UserSearchResult;
import com.example.mostafahussien.archcomp_retrofit_demo.ViewModel.RepoListViewModel;
import com.example.mostafahussien.archcomp_retrofit_demo.ViewModel.UserViewModel;
import com.example.mostafahussien.archcomp_retrofit_demo.databinding.FragmentMainBinding;

import java.util.List;


public class MainFragment extends Fragment {

    UserViewModel userViewModel;
    RepoListViewModel repoListViewModel;
    FragmentMainBinding binding;
    private ReposAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userViewModel=ViewModelProviders.of(this).get(UserViewModel.class);
        repoListViewModel=ViewModelProviders.of(this).get(RepoListViewModel.class);
        adapter=new ReposAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        //Will change the UI when userLiveData will have
        userViewModel.getUserLiveData().observe(this, new Observer<UserSearchResult>() {
            @Override
            public void onChanged(@Nullable UserSearchResult userSearchResult) {
                if(userSearchResult.success()){
                    binding.setUser(userSearchResult.getUser());
                }
            }
        });

        //fetch the repos from the datasource, and update whe UI
        repoListViewModel.getReposLiveData().observe(this, new Observer<List<Repo>>() {
            @Override
            public void onChanged(@Nullable List<Repo> repos) {
                adapter.setRepos(repos);
            }
        });

        binding.local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userViewModel.searchLocally("kevin");
            }
        });

        binding.network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userViewModel.serachOnline("mostafa9696");
            }
        });

        repoListViewModel.searchRepos("mostafa9696");
    }

}
