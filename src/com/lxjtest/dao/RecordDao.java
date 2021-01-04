package com.lxjtest.dao;

import com.lxjtest.entity.Record;
import com.lxjtest.entity.Survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordDao {
    public static int insert(Record record) {
        Connection connection = BaseDao.getConn();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "insert into record (SURVEY_ID,BIRD_NAME,BIRD_NUMBER,BIRD_PICTURE_URL)values(?,?,?,?)";
        Object[] params={
                record.getSURVEY_ID(),
                record.getBIRD_NAME(),
                record.getBIRD_NUMBER(),
                record.getBIRD_PICTURE_URL()
        };
        return BaseDao.executeSql(sql,params);
    }

    public static ArrayList<Record> selectRecord(String surveyid) {
        ArrayList<Record> list=new ArrayList<>();

        Connection connection=BaseDao.getConn();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;

        try {
            String sql="select * from record where SURVEY_ID=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(surveyid));
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                Record record=new Record(
                        resultSet.getInt("SURVEY_ID"),
                        resultSet.getString("BIRD_NAME"),
                        resultSet.getString("BIRD_NUMBER"),
                        resultSet.getString("BIRD_PICTURE_URL")
                );
                record.setRECORD_ID(resultSet.getInt("RECORD_ID"));
                list.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeAll(resultSet,preparedStatement,connection);
        }

        return list;
    }
}
