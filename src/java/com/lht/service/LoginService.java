package com.lht.service;

import com.lht.pojo.User;

import java.util.List;

public interface LoginService {
    public List<User> login(String username,String password);
}
