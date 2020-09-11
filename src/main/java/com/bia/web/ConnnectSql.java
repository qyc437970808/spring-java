package com.bia.web;

import java.sql.*;

public class ConnnectSql {
    static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://192.168.1.204:3306/auto_test";

    static final String USER="root";
    static final String PASS="123456";
    public String[] returnSql(){
        Connection conn=null;
        Statement stmt=null;
        String[] myList={"0"};
        try {
            System.out.println("链接数据库....");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ID, ProdName FROM a";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            String returnString="";
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("ID");
                String name = rs.getString("ProdName");
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 产品名称: " + name);
                System.out.print(", 产品名称: " + name);
                returnString+=(id+": " + name);
                myList[0]=returnString;
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
        System.out.println(myList);
        return myList;
    }
    public static void main(String[] args){
    }
}
