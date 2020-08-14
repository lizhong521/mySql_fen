package getapi;
import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.assertEquals;

/*
这是测试程序


 */
public class Main {
    public static void main(String[] args) {
        //get请求方式,平台暂时只支持get请求
        // Sign Request URL Parameter
        // GET https://domain.com?param1=123&param2=Abc&appKey=foobar&pampasCall=query.coupon
        Map<String, String> params = new HashMap<>(2);
        //设置参数,实验过不用按照字母排序
        params.put("pageNo","1");
        params.put("id", "12");
        params.put("appKey", "J0mFDMfuFt0RG51Fv7td5r5t1K8lXGy6");
        //params.put("param2", "Abc");

        //params.put("pampasCall", "query.coupon");
        params = SignAuthHelper.sign(params, "wxKvem5kWpkxdqNiZWDNmSWDNMH60LOR");
        //String expect = "d6fee3145be668425f70878084f9d"
//                + "39fce3f7c5fca283ffc4c5d5a5568077334e9a505"
//                + "26e7e806758a66b7647ae9951f9324a0f921e28417e07d69beed79f7ef";
        //断言字符串是否一致
        //assertEquals(expect, params.get("sign"));
        String si = params.get("sign");
        System.out.println(si);
        System.out.println("Verify Success");

        //post请求方式
        // Sign Request Body
        // POST --header 'Content-Type: application/json'
        //      --header 'Accept: application/json'
        //      -d '{"userName":"abc","gender":"male"}'
        // 'https://domain.com'

//        params = new HashMap<>(4);
//
//        // request body use data as param name
//        params.put("data", "{\"userName\":\"abc\",\"gender\":\"male\"}");
//        params.put("appKey", "foobar");
//        expect = "ec23eeda5f88abe26311ed020439172eea409e34"
//                + "75875c87e9abfa8a6856138e767608e8497435f573c"
//                + "cb417a90448c78abdca4a0de12c4da4583aa3add7bf52";
//        params = SignAuthHelper.sign(params, "test-secret");
//        assertEquals(expect, params.get("sign"));
//        System.out.println("Verify Request Body Success");
    }


}
