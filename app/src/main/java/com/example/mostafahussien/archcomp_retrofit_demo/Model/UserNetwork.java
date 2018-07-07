package com.example.mostafahussien.archcomp_retrofit_demo.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mostafa Hussien on 03/07/2018.
 */

public class UserNetwork {

    @SerializedName("avatar_url")
    String avatarUrl;
    @SerializedName("name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public User toUser(){
        final User user = new User();
        user.setName(getName());
        user.setAvatarUrl(getAvatarUrl());
        return user;
    }
}
