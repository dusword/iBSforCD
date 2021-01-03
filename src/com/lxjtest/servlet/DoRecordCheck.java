package com.lxjtest.servlet;

import com.lxjtest.dao.RecordDao;
import com.lxjtest.dao.SurveyDao;
import com.lxjtest.entity.Record;
import com.lxjtest.entity.Survey;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DoRecordCheck")
public class DoRecordCheck extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String surveyid=request.getParameter("surveyid");
        ArrayList<Record> list= RecordDao.selectRecord(surveyid);
        request.setAttribute("recordlist",list);
        request.getRequestDispatcher("recordcheck.jsp").forward(request,response);

    }
}
