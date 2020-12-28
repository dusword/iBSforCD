package com.lxjtest.servlet;

import com.lxjtest.dao.UserDao;
import com.lxjtest.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DoUserSelect")
public class DoUserSelect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> list =UserDao.selectAll();
        request.setAttribute("userlist",list);
        request.getRequestDispatcher("succeed.jsp").forward(request,response);
    }
}
