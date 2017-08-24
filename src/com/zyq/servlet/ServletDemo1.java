package com.zyq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/*
 * Created by 周元庆 on 2017/8/24.
 * servlet 是sun公司定义的一组java api tomcat servlet容器
 * 服务器启动的时候 会初始化 HttpServlet
 * 我们访问Servlet的时候，会初始化我们URL对应的Servlet 执行Servlet方法 执行get/post
 * 第二次访问的时候 不会初始化对应Servlet 直接调用Servlet方法处理请求 执行get/post
 * 后续访问一直调用service方法提供服务
 */
//只有继承HttpServlet tomcat才能找到的
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        不管tomcat有没有设置过字符编码，都需要转义。get请求中，如果地址栏中有输入中文，必须要设置tomcat编码才能使用。
        String name = new String(request.getParameter("namep").getBytes("ISO-8859-1"), "UTF-8");
//        String name=request.getParameter("name");
        String pwd = request.getParameter("pwdp");
        System.out.println("post请求：" + name + "的密码是：" + pwd);

        String p = request.getContextPath();//显示工程名
        String x = request.getRequestURI();//工程名下的地址
        String a = request.getRequestURL().toString();//地址
        String y = request.getRemoteAddr();//ipv6
        String z = request.getRemoteHost();//ip地址
        Map<String, String[]> map = request.getParameterMap();
        String namemap = new String(request.getParameter(map.get("namep")[0]).getBytes("ISO-8859-1"), "UTF-8");
        String pwdmap = new String(request.getParameter(map.get("pwdp")[0]).getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("post请求map：" + name + "的密码是：" + pwd);
        System.out.println("post请求map：" + namemap + "的密码是：" + pwdmap);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*为防止地址栏中有中文，需要将Tomcat的配置文件设置一下。
        tomcat目录/conf/server.xml,找到<Connector port="8080" protocol="HTTP/1.1" 这一行
        添加 URIEncoding="UTF-8" useBodyEncodingForURI="true"
        最后重启tomcat*/

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name + "的密码是：" + pwd);
    }
}
