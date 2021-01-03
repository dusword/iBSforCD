package com.lxjtest.dao;


import com.lxjtest.entity.Survey;
import com.lxjtest.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SurveyDao{
    public static int insert(Survey survey) {
        Connection connection = BaseDao.getConn();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

            String sql = "insert into survey (SURVEY_NAME,SURVEY_USER_ID,SURVEY_PLACE)values(?,?,?)";
            Object[] params={
                survey.getSURVEY_NAME(),
                survey.getSURVEY_USER_ID(),
                survey.getSURVEY_PLACE()
            };
        return BaseDao.executeSql(sql,params);

    }

    public static Survey adminSurvey(String surveyname,int surveyuserid,String surveyplace) {
        Connection connection = BaseDao.getConn();
        Survey survey = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from survey where SURVEY_NAME=? and SURVEY_USER_ID=? and SURVEY_PLACE=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, surveyname);
            preparedStatement.setInt(2,surveyuserid);
            preparedStatement.setString(3, surveyplace);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                survey = new Survey(
                        resultSet.getString("SURVEY_NAME"),
                        resultSet.getInt("SURVEY_USER_ID"),
                        resultSet.getString("SURVEY_PLACE")

                );
                survey.setSURVEY_ID(resultSet.getInt("SURVEY_ID"));
                survey.setSURVEY_DATE(resultSet.getDate("SURVEY_DATE"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(resultSet, preparedStatement, connection);
        }
        return survey;
    }




    public static ArrayList<Survey> selectUserSurvey(int user_id) {
        ArrayList<Survey> list=new ArrayList<>();

        Connection connection=BaseDao.getConn();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;

        try {
            String sql="select * from survey where SURVEY_USER_ID=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                Survey survey=new Survey(
                        resultSet.getString("SURVEY_NAME"),
                        user_id,
                        resultSet.getString("SURVEY_PLACE")
                );
                survey.setSURVEY_ID(resultSet.getInt("SURVEY_ID"));
                survey.setSURVEY_DATE(resultSet.getDate("SURVEY_DATE"));
                list.add(survey);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,preparedStatement,connection);
        }

        return list;
    }

    public static int surveyDel(String surveyid) {

        String sql="delete from survey where SURVEY_ID=?";
        Object[] params={surveyid};
        return  BaseDao.executeSql(sql,params);

    }
}
