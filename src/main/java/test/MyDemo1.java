package test;

import bean.Student;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcUtils;
import sun.awt.EventQueueItem;
import utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MyDemo1 {


    public static void main(String[] args) throws Exception {



        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="insert into student values(?,?)";
        JSONReader reader = new JSONReader(new FileReader("D:\\mydata.txt"));

        reader.startArray();
        Student stu = new Student();
        while (reader.hasNext()){
            String key = reader.readString();
            String zhi = reader.readObject().toString();
            if (key.equals("name")){
                stu.setName(zhi);
            }else if (key.equals("id")){
                stu.setId(Integer.parseInt(zhi));
            }


        }

        template.update(sql,stu.getId(),stu.getName());
        reader.endArray();





    }
/*private static void addTable(Student stu) throws SQLException {
String sql="insert into student valuse(?,?)";

    PreparedStatement pstm = con.prepareStatement(sql);
pstm.setString(1,stu.getName());
pstm.setInt(2,stu.getId());
pstm.execute();
}*/
}
