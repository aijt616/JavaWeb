package com.zyq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 2017/8/24.
 */
public class ServletFilter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        有了Filter，可以不用转义
//        String name = new String(request.getParameter("namep").getBytes("ISO-8859-1"), "UTF-8");
        String name=request.getParameter("namep");
        String pwd = request.getParameter("pwdp");
        System.out.println("post请求：" + name + "的密码是：" + pwd);
    }


}
