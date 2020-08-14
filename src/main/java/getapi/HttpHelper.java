package getapi;


import java.util.Dictionary;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpHelper {
    /// <summary>
    /// 指定Post地址使用Get 方式获取全部字符串
    /// </summary>
    /// <param name="url">请求后台地址</param>
    /// <returns></returns>
    private static void myGet() throws IOException {

        //建立连接请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get请求
        HttpGet get=new HttpGet("https://fdp-service-prod.app.terminus.io/ceshi1?pageNo=1&appKey=J0mFDMfuFt0RG51Fv7td5r5t1K8lXGy6&sign=9d1862b39cc334fd333f3fc45d5f24ef8c408dbca3e6e9c4164bc0597bd1adb87de0d3c3728b0286d86c762de6244802a190a4369de900000041cce3445f0b5f");
        CloseableHttpResponse response = httpClient.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        //响应成功在操作
        if (statusCode==200) {
            //获取响应实体
            HttpEntity entity = response.getEntity();

            //打印响应内容长度
            System.out.println("响应文本长度:"+entity.getContentLength());
            //打印响应内容
            System.out.println("响应内容如下:\n"+EntityUtils.toString(entity,"UTF-8"));
        }else {
            System.out.println("响应失败");
        }
        System.out.println("--------------------------响应内容打印完毕");
        //释放资源
        response.close();
        httpClient.close();
    }

    public static void main(String[] args) {
        try {
             myGet();
           // myPost();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
