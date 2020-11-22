package com.he.test;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置一个全局的  servlet 属性，可以全局获取
        ServletContext servletContext = this.getServletContext();
        String name = "何金玉";
        servletContext.setAttribute("name",name);
    }
}
