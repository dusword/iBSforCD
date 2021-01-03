package com.lxjtest.servlet;

import com.lxjtest.dao.RecordDao;
import com.lxjtest.entity.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DoRecordAdd")
public class DoRecordAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String birdname=request.getParameter("birdname");
        String birdnumber=request.getParameter("birdnumber");

        int surveyid= (int) request.getSession().getAttribute("surveyid");


        Record record=new Record(surveyid,birdname,birdnumber);
        int count=0;
        count=RecordDao.insert(record);

        if (count > 0) {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>");
            printWriter.println("alert('添加成功！')");
            printWriter.println("</script>");
            request.getRequestDispatcher("record.jsp").forward(request,response);
//            request.setAttribute("");

        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>");
            printWriter.println("alert('添加失败！')");
            printWriter.println("location.href='record.jsp'");
            printWriter.println("</script>");

        }
    }
}
