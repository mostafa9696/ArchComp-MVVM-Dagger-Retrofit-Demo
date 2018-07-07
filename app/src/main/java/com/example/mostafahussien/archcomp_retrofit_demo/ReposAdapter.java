package com.example.mostafahussien.archcomp_retrofit_demo;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mostafahussien.archcomp_retrofit_demo.Model.Repo;
import com.example.mostafahussien.archcomp_retrofit_demo.databinding.RepoRowBinding;

import java.util.ArrayList;
import java.util.List;



public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {

    private final List<Repo> repoList = new ArrayList<>();

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RepoRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.repo_row, parent, false);
        return new RepoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.binding.setRepo(repoList.get(position));
    }

    public void setRepos(List<Repo> repos){
        this.repoList.clear();
        this.repoList.addAll(repos);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {

        final RepoRowBinding binding;

        public RepoViewHolder(RepoRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
