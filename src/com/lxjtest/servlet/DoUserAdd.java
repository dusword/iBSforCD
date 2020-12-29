package com.lxjtest.servlet;

import com.lxjtest.dao.UserDao;
import com.lxjtest.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DoUserAdd")
public class DoUserAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

//        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        User user=new User(username,password);

        int count= UserDao.insert(user);

        if (count>0)
        {
            PrintWriter printWriter=response.getWriter();
            printWriter.println("<script>");
            printWriter.println("alert('注册成功！')");
            printWriter.println("location.href='DoUserSelect'");
            printWriter.println("</script>");
        }else {
            PrintWriter printWriter=response.getWriter();
            printWriter.println("<script>");
            printWriter.println("alert('注册失败，用户名已存在！')");
            printWriter.println("location.href='index.jsp'");
            printWriter.println("</script>");
//            response.sendRedirect("failed.jsp");
        }
    }

}
