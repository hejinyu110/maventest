package com.he.dao.user;

import com.he.dao.BaseDao;
import com.he.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//dao 接口实现类
public class UserDaolmpl implements UserDao{
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        return null;
    }

    @Override
    public int updatePwd(Connection connection,int id, String password) throws SQLException {
        System.out.println("userServlet"+password);
        PreparedStatement pstm = null;
        int execute =0;
        if (connection != null) {
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object params[] = {password,id};
            execute = BaseDao.execute(connection,pstm,sql,params);
            BaseDao.closeResource(null,pstm,null);
        }
    }

    @Override
    public int getUserCount(Connection connection, String username, String userRole) throws SQLException {

    }


}
