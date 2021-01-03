package com.lxjtest.dao;


import com.lxjtest.entity.Survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SurveyDao{
    public static int insert(Survey survey){
        int count=0;
        Connection connection=BaseDao.getConn();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement = null;

        String sql="insert into survey (SURVEY_NAME,SURVEY_USER_ID,SURVEY_PLACE)values(?,?,?)";
        Object[] params={
                survey.getSURVEY_NAME(),
                survey.getSURVEYUSER_ID(),
                survey.getSURVEY_PLACE()
        };
        return BaseDao.executeSql(sql,params);
    }
}
