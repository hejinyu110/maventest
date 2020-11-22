package com.he.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh","3");//3 秒自动刷新
        //内存中创建一个图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_BGR);

        //得到一个图片
        Graphics2D g = (Graphics2D) image.getGraphics();//笔
        g.setColor(Color.white);//设置图片的背景色
        g.fillRect(0,0,80,20);
        g.setColor(Color.blue); //设置数据
        //设置数据的  属性  是否加粗  字号
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);
        resp.setContentType("image/jpeg");
        resp.setDateHeader("expires",-1);//不缓存
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("pragma","no-cache");
        //图片写入到浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
//        resp.sendRedirect("/aaa/b");//url  重定向
    }
    //生成随机数
    private String makeNum(){
        Random rd = new Random();
        String num = rd.nextInt(9999999)+"";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString()+num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
