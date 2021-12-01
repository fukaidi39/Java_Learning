package zju.com.util;

import java.io.*;
import java.util.Scanner;

/**
 * @Autor:godfu
 * @Date:2021/11/29-20:13
 */

public class FileUtil {
    /**
     * 从文件中读取信息
     * @param file 加载的文件
     * @return 读取的信息
     */

    public static String load(File file){
        Scanner scan = null;
        try {
            scan = new Scanner(new FileInputStream(file));
            if (scan.hasNext()){//有信息
                String content = scan.next();
                return content;
            }else{
                return null;
            }
        } catch (FileNotFoundException e) {
            return null;
        }finally{
            if(scan != null){
                scan.close();
            }
        }
    }

    /**
     * 将数据追加到文件中
     * @param file 保存的文件
     * @param content 保存的内容
     */
    public static void append(File file, String content){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(file,true));
            pw.print(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            pw.close();
        }
    }

}
