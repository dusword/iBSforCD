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
            response.sendRedirect("DoUserSelect");
        }else {
            PrintWriter out= response.getWriter();
            // TODO: 2020/12/28 create by lxj 优化script显示
//            out.println("<html>");
//            out.println("<head><meta charset='utf-8'/><title>test</title></head>");
//            out.println("<body>");
            out.println("<script>");
            out.println("alert('失败')");
            out.println("location.href='index.jsp'");
            out.println("</script>");
//            out.println("</body>");
//            out.println("</html>");
//            out.flush();
//            out.close();
        }


    }

}
