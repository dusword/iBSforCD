package com.lxjtest.servlet;

import com.lxjtest.dao.UserDao;
import com.lxjtest.entity.User;
import org.apache.tomcat.util.buf.UDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DoUserLogin")
public class DoUserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("test/html;charset=utf-8");

//        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        int count= UserDao.verify(username,password);

        if (count>0){
            response.sendRedirect("DoUserSelect");
        }else {
            PrintWriter out= response.getWriter();
            out.write("<script>");
            out.write("alert'失败'");
            out.write("location.href='failed.jsp'");
            out.write("</script>");
            out.close();
        }


    }

}
