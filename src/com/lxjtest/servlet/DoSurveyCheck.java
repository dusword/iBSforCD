package com.lxjtest.servlet;

import com.lxjtest.dao.SurveyDao;
import com.lxjtest.entity.Survey;
import com.lxjtest.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DoSurveyCheck")
public class DoSurveyCheck extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        User user = (User) request.getSession().getAttribute("user");
        ArrayList<Survey> list= SurveyDao.selectUserSurvey(user.getUSER_ID());
        request.setAttribute("usersurveylist",list);
        request.getRequestDispatcher("surveycheck.jsp").forward(request,response);
    }
}
