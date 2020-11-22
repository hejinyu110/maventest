package com.he.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取下载文件路径
        String filePath = this.getServletContext().getRealPath("/1.png");
        System.out.println("下载文件路径"+filePath);
//        2.获取下载文件名
        //截取最后一个文件名称
        String filename = filePath.substring(filePath.lastIndexOf("\\")+1);
//         3.设置文件流的头信息
        //URLEncoder 转换文件编码，防止中文文件名称错误
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        //4.获取下载文件的输入流
        FileInputStream in = new FileInputStream(filePath);
        //5.创建缓冲区
        int len =0 ;
        byte[] buffer = new byte[1024];
        //6 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7.将fileOutStream 流写入到缓冲区 buffer,使用OutPutStream将缓冲区输出到客户端
        while((len = in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }
}
