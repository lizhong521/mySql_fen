package getapi;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.security.MessageDigest;
import java.util.stream.Collectors;
/*

这是签名实现
不用改,直接在测试程序中调用

 */


public class SignAuthHelper {

    public static Map<String, String> sign(Map<String,String> args, String appSecret) {
        args.put("appKey", args.get("appKey"));
        List<String> keyList = args.entrySet().stream().map(Map.Entry::getKey).sorted().collect(Collectors.toList());
        List<String> kvList = new ArrayList<>();
        for (String key: keyList) {
            kvList.add(key + "=" + args.get(key));
        }
        String argsStr = StringUtils.join(kvList, "&") + appSecret;
        String sign = string2SHA512(argsStr);
        args.put("sign", sign);
        return args;
    }




    private static String string2SHA512(String str) {
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

}
