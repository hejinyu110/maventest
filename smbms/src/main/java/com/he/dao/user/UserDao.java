package com.he.dao.user;

import com.he.pojo.User;

import java.sql.Connection;

public interface UserDao {
    //得到登录用户
    public User getLoginUser(Connection connection, String userCode);
}
