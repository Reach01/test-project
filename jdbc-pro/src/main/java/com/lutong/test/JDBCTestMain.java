package com.lutong.test;

import java.sql.*;

/**
 * 测试jdbc连接
 */
public class JDBCTestMain {
    public static void main(String[] args) {
        /*String url = "jdbc:informix-sqli://10.1.69.150:7779/CRBT_GS:informixserver=dbserver;NEWLOCALE=zh_CN,en_us;NEWCODESET=gbk,8859-1,819;IFX_LOCK_MODE_WAIT=10";
        String username = "gansu";
        String password = "1qaz@WSX";*/

        String url = "jdbc:informix-sqli://192.168.29.55:7779/web:informixserver=hdr1;NEWLOCALE=zh_CN,en_us;NEWCODESET=gbk,8859-1,819;IFX_LOCK_MODE_WAIT=10";
        String username = "informix";
        String password = "EEbupt%#!642";
        try {
            Class.forName("com.informix.jdbc.IfxDriver");
            Connection con = DriverManager.getConnection(url, username , password);
            String sql = "select skip 20 first 10 phonenumber,ringid,addtime,type from vrbt_usersetting us,vrbt_usersettingring usr " +
                    "where us.usersettingindex = usr.usersettingindex order by addtime ";
            PreparedStatement pstmt = con.prepareStatement(sql) ;
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                String phoneNumber = resultSet.getString("phoneNumber") ;
                String ringid = resultSet.getString("ringid");
                String addtime = resultSet.getString("addtime");
                String type = resultSet.getString(4);
                System.out.println("电话号码：" + phoneNumber + "," + ringid + ","+addtime+","+type);
                //String pass = rs.getString(1) ; // 此方法比较高效
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
