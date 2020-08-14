package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getJdbc {
    public static Connection getJDBC(String url,String user,String password){
        Connection con=null;
        String driver = "com.mysql.jdbc.Driver";
        //加载驱动程序
        try {
            Class.forName(driver);
            //连接mysql数据库
            con=DriverManager.getConnection(url,user,password);



        } catch (Exception e) {
            System.out.println("mysql数据库连接不成功,错误是"+e);
        }

        return con;
    }
}
