package zju.com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Autor:godfu
 * @Date:2021/11/28-22:30
 */
public class InputUtil {
    private InputUtil() {
    }

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 实现对键入数字的保存
     *
     * @param prompt 提示信息
     * @return 保存的数字
     */
    public static int getInt(String prompt) {
        System.out.println(prompt);
        boolean flag = true;
        int result = 0;
        while (flag) {
            if (scan.hasNext("\\d+")) {
                result = Integer.parseInt(scan.next());
                flag = false;
            } else {
                System.out.println("输入错误，" + prompt);
                scan.next();//跳过错误，继续下一个键入
            }
        }
        return result;
    }

    /**
     * 使用Bufferedreader因为其能按行读，检测空
     * 获取键入的字符串信息并保存
     *
     * @param prompt ：提示信息
     * @return 保存的字符串
     */
    public static String getString(String prompt){
        String data = null;
        boolean flag = true;
        while (flag) {
            System.out.println(prompt);
            try {
                data = bfr.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!"".equals(data)) {
                flag = false;
            } else {
                System.out.print("输入错误");
            }
        }

        return data;
    }
}

