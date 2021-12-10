package zju.web;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Autor:godfu
 * @Date:2021/12/10-16:29
 */
public class EchoClient {
    private static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //定义服务端连接
        Socket client = new Socket("localhost", 8080);
        //读入服务器的输入内容
        Scanner scanner = new Scanner(client.getInputStream());
        scanner.useDelimiter("\n");//设置分隔符
        //向服务器发送内容
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        boolean flag = true;
        while(flag){
            //从键盘中读入数据
            System.out.print("请输入要发送的内容:");
            String data = SC.nextLine().trim();//逐行读取键盘中的数据
            //消息内容发送给服务端
            pw.println(data);
            pw.flush();
            //读取服务端返回的消息
            if (scanner.hasNext()){
                System.out.println(scanner.next());
            }
            if ("Bye".equalsIgnoreCase(data)){
                flag = false;
            }
        }
        scanner.close();
        client.close();
        pw.close();
    }
}
