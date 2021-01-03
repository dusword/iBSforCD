package com.lxjtest.servlet;

import com.lxjtest.dao.UserDao;
import com.lxjtest.entity.User;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.tomcat.util.buf.UDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DoUserLogin")
public class DoUserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

//        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        int count= UserDao.verify(username,password);

        if (count>0){
            User user=UserDao.adminUser(username,password);
            request.setAttribute("user",user);
            request.setAttribute("isLogin","1");
            request.getSession().setAttribute("user",user);
            request.getSession().setAttribute("isLoginS","1");
            request.getRequestDispatcher("succeed.jsp").forward(request,response);
//            PrintWriter printWriter=response.getWriter();
//            printWriter.println("<script>");
//            printWriter.println("alert('登陆成功')");
//            printWriter.println("location.href='DoUserSelect'");
//            printWriter.println("</script>");
//            response.sendRedirect("DoUserSelect");
        }else {
            PrintWriter out= response.getWriter();
            // TODO: 2020/12/28 create by lxj 优化script显示
            out.println("<script>");
            out.println("alert('失败')");
            out.println("location.href='index.jsp'");
            out.println("</script>");

        }


    }

}
