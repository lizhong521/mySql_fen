package test;

import bean.CityBean;
import com.alibaba.fastjson.JSONReader;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.io.FileReader;

public class MyDemo {
    public static void main(String[] args) throws Exception {
        //获取jdbc解析数据连接池
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "insert into city values(?,?,?,?)";//定义sql


        JSONReader reader = new JSONReader(new FileReader("D:\\mydata.txt"));
        reader.startObject();//开始解析最外层的对象

        while (reader.hasNext())//遍历最外层的对象
        {
            String key = reader.readString(); //读取键的值
            if (key.equals("resultcode")) {
                String zhi = reader.readObject().toString();
                System.out.println("resultcode为：" + zhi);

            } else if (key.equals("reason")) {
                String zhi = reader.readObject().toString();
                System.out.println("reason为：" + zhi);

            } else if (key.equals("result")) {
                reader.startArray();//开始解析数组
                while (reader.hasNext())//遍历数组
                {
                    CityBean cityBean = new CityBean();//创建city对象
                    reader.startObject();//开始解析最内层的对象
                    while (reader.hasNext())//遍历最内层的对象
                    {

                        String jian = reader.readString();
                        String zhi = reader.readObject().toString();
                        //封装对象，给对象设置属性值
                        if (jian.equals("id")) {
                            cityBean.setId(Integer.parseInt(zhi));
                        }
                        if (jian.equals("province")) {
                            cityBean.setProvince(zhi);
                        }
                        if (jian.equals("city")) {
                            cityBean.setCity(zhi);
                        }
                        if (jian.equals("district")) {
                            cityBean.setDistrict(zhi);
                            /*
                      //下面是关于json中出现时间格式的数值插入到mysql的相关操作
                     String date = arrayObject.get("starttime").getAsString().toString();

                     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                     Date myDate = dateFormat.parse(date);
                     Format format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                     String str=format.format(myDate);

                             */
                        }

                    }
                    template.update(sql, cityBean.getId(), cityBean.getProvince(), cityBean.getCity(), cityBean.getDistrict());//执行sql
                    reader.endObject();
                }
                reader.endArray();

            } else if (key.equals("error_code")) {
                String zhi = reader.readObject().toString();
                System.out.println("error_code为：" + zhi);

            }

        }


        reader.endObject();//结束解析最外层的对象

    }


}
