package com.he.dao.user;

import com.he.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    //得到登录用户
    public User getLoginUser(Connection connection, String userCode) throws  SQLException;

    public int updatePwd(Connection connection,int id,String password) throws SQLException;

    //根据用户名 或者角色查询用户总数
    public int getUserCount(Connection connection, String username,String userRole) throws SQLException;
}
