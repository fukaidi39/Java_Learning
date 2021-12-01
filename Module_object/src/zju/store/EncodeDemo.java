package zju.store;

import java.util.Base64;

/**
 * @Autor:godfu
 * @Date:2021/11/20-14:41
 */

public class EncodeDemo {
    public static void main(String[] args) {
        //加密
        String salt = "{Shandong university}";
        String str = "fkd is from Zhejiang university." + salt;
        String encode = new String(Base64.getEncoder().encode(str.getBytes()));
        //解密
        String code = new String(Base64.getDecoder().decode(encode));
        System.out.println(code.replaceAll("\\{\\w+\\s\\w+\\}",""));
    }
}
