package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils_j {
    public static void main(String[] args) {
        // 声明Connection对象
        Connection con;
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名 test
        String url = "jdbc:mysql://124.128.194.82:3700/demo";
        //String url = "jdbc:mysql://192.168.133.104:3307/test";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "waterinfo";
        // 遍历查询结果集
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！

            con= DriverManager.getConnection(url,user,password);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + user + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句
            String sql = "select * from demo1";
            // 3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("\n\t\t执行结果如下所示:");
            System.out.println("\t\t-----------------------------------------------------------------");

            //System.out.println("\t\t|\t" + "ID" + "\t" + "姓名" + "\t" + "性别" + "\t" + "年龄" + "\t" + "手机号码" + "\t\t" + "地址\t|");
            System.out.println("\t\t-----------------------------------------------------------------");

            int ID = 0;
            String Name = null;
            String Sex = null;
            int Age = 0;
            String Phone = null;
            String Address = null;

            while (rs.next()) {
                // 获取 ID 这列数据
               // ID = rs.getInt("ID");
                // 获取 Name 这列数据
                Name = rs.getString("Name");
                // 获取 Sex 这列数据
               // Sex = rs.getString("Sex");
                // 获取 Age 这列数据
               // Age = rs.getInt("Age");
                // 获取 Phone 这列数据
                //Phone = rs.getString("Phone");
                // 获取 Address 这列数据
               // Address = rs.getString("Address");
                // 输出结果
                //System.out.println("\t\t|\t" + ID + "\t" + Name + "\t" + Sex + "\t" + Age + "\t" + Phone + "\t" + Address + "\t|\t\t");
                System.out.println(Name);
            }
            System.out.println("\t\t-----------------------------------------------------------------");
            rs.close();
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally {
            System.out.println("\t\t\t\t\t\t\t\t获取数据库数据完毕！!！");
        }




    }

}
