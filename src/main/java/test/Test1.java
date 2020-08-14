package test;


import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;

public class Test1 {
    public static void main(String[] args) {

       Connection con= utils.getJdbc.getJDBC("jdbc:mysql://192.168.133.104:3307/test?&autoReconnect=true&failOverReadOnly=false","root","123456");
        //创建statement类对象，用来执行SQL语句！
        try {
            Statement sql=con.createStatement();
            String sql1="insert into demo1 values('lizhong')";
            sql.executeUpdate(sql1);


            sql.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
