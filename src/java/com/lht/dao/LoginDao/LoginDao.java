package com.lht.dao.LoginDao;

import com.lht.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao {
    public List<User> login(@Param("username")String username,@Param("password")String password);

}
