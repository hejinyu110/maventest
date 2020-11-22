package com.he.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demos5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取 Resourse 中定义的文件属性 的文件流信息
        // 路径为打包之后生成的文件路径，项目打包之后的文件全部生成在 target/项目/WEB-INF/classes
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        //流信息转换为属性值 打印
        Properties prop = new Properties();
        prop.load(is);
        String user = prop.getProperty("username");
        String password = prop.getProperty("password");
        resp.getWriter().print(user+":"+password);
    }
}
