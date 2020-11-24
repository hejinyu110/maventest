package com.he.dao;

import com.mysql.jdbc.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BaseDao  {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块类 加载的时候就会初始化
    static  {
        //通过类加载器    读取对应的资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }
    //获取数据库的连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    //编写查询公共类
    public static ResultSet execute(Connection connection, String sql, Object[] params, ResultSet resultSet, com.mysql.jdbc.PreparedStatement preparedStatement) throws Exception{
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        resultSet = preparedStatement.executeQuery(sql);
        return resultSet;
    }
}
