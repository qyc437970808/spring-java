package com.bia.web;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnnectSql {
    static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://192.168.1.204:3306/auto_test";

    static final String USER="root";
    static final String PASS="123456";
    public List<Map<String,Object>> returnSql(String sql){
        Connection conn=null;
        Statement stmt=null;
        List<Map<String,Object>> myList= new ArrayList<Map<String,Object>>();
        try {
            System.out.println("链接数据库....");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("ID");
                String name = rs.getString("ProdName");
                // 输出数据
                Map<String,Object> myMap=new HashMap<>();
                myMap.put("id",id);
                myMap.put("name",name);
                myList.add(myMap);
            }
            rs.close();
            stmt.close();
            conn.close();

        }catch (SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
        return myList;
    }
    public static void main(String[] args){
    }
}
