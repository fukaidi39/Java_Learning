package zju.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Autor:godfu
 * @Date:2021/12/10-16:29
 */
public class EchoServer {
    //为每一个接收的客户端提供多线程连接
    private static class ClientThread implements Runnable{
        private Socket client = null;
        private Scanner scanner = null;
        private PrintWriter pw = null;
        private boolean flag = true;
        public ClientThread(Socket client)throws Exception{
            this.client = client;
            //接受客户端的信息
            this.scanner = new Scanner(client.getInputStream());
            scanner.useDelimiter("\n");//设置读取分隔符
            //服务端输出流,等待被客户端接受
             this.pw = new PrintWriter(client.getOutputStream());
        }
        @Override
        public void run() {
            while(flag){
                //有数据发送
                if(scanner.hasNext()){
                    String val = scanner.next().trim();
                    if (val.equalsIgnoreCase("bye")){
                        //输出流
                        pw.println("Bye Bye");
                        flag = false;
                    }else{
                        pw.println("[ECHO]" + val);
                        pw.flush();//刷新缓冲区
                    }
                }
            }
            try {
                client.close();
                scanner.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)throws Exception {
        //设置服务器监听端口
        ServerSocket server = new ServerSocket(8080);
        System.out.println("等待客户端连接......");
        //客户端连接
        boolean flag = true;
        while(flag){
            Socket client = server.accept();
            new Thread(new ClientThread(client)).start();

        }
        server.close();
    }
}
