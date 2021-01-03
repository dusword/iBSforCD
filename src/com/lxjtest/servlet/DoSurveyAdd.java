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
import java.io.PrintWriter;

@WebServlet("/DoSurveyAdd")
public class DoSurveyAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String surveyname = request.getParameter("surveyname");
        String surveyplace = request.getParameter("surveyplace");
        User user = (User) request.getSession().getAttribute("user");
        int surveyuserid=user.getUSER_ID();


        Survey survey = new Survey(surveyname, surveyuserid, surveyplace);
        SurveyDao.insert(survey);

        int surveyid=0;
        Survey survey1=SurveyDao.adminSurvey(surveyname,surveyuserid,surveyplace);
        surveyid=survey1.getSURVEY_ID();


        if (surveyid > 0) {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>");
            printWriter.println("alert('创建成功！')");
            printWriter.println("</script>");
            request.getSession().setAttribute("surveyid",surveyid);
            request.getRequestDispatcher("record.jsp").forward(request,response);
//            request.setAttribute("");

        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>");
            printWriter.println("alert('注册失败！')");
            printWriter.println("location.href='survey.jsp'");
            printWriter.println("</script>");

        }

    }
}
