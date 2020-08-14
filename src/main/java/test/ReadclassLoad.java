package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadclassLoad {



    public static void main(String[] args) throws IOException {
        //1、获取类加载器
        //ClassLoader cd = ReadclassLoad.class.getClassLoader();
        //2、用类加载器读取文件信息
        //InputStream stream = cd.getResourceAsStream("jdbc.properties");
        String path="jdbc.properties";
        InputStream stream = ReadclassLoad.class.getClassLoader().getResourceAsStream(path);
        //3、创建数组，遍历文件信息
        Properties props = new Properties();
        try {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 通过key获取value
        String driverClassName = props.getProperty("driverClassName");
        //String url = props.getProperty("url");
        //String user = props.getProperty("user");
        //String pwd = props.getProperty("password");

        System.out.println(driverClassName);

    }

}
