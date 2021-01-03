package com.lxjtest.servlet;

import com.lxjtest.dao.SurveyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DoSurveyRemove")
public class DoSurveyRemove extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        String surveyid=request.getParameter("surveyid");
        int count= SurveyDao.surveyDel(surveyid);

        if (count>0)
        {
            PrintWriter printWriter=response.getWriter();
            printWriter.println("<script>");
            printWriter.println("alert('删除成功！')");
            printWriter.println("location.href='DoSurveyCheck'");
            printWriter.println("</script>");
        }else {
            PrintWriter printWriter=response.getWriter();
            printWriter.println("<script>");
            printWriter.println("alert('失败！')");
            printWriter.println("location.href='DoSurveyCheck.jsp'");
            printWriter.println("</script>");
//            response.sendRedirect("failed.jsp");
        }

    }

}
