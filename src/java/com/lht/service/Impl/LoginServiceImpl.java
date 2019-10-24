package com.lht.service.Impl;

import com.lht.dao.LoginDao.LoginDao;
import com.lht.pojo.User;
import com.lht.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public List<User> login(String username, String password) {
        return loginDao.login(username,password);
    }
}
