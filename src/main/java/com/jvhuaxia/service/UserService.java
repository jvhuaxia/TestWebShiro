package com.jvhuaxia.service;


import com.jvhuaxia.pojo.User;

public interface UserService {
    public void saveUser(User user);

    public User getUser(String userName);
}
