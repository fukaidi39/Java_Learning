package zju.web.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Autor:godfu
 * @Date:2021/12/10-21:42
 */
public class UDPServer {
    public static void main(String[] args) throws Exception{
        //开启网络服务端
        DatagramSocket server = new DatagramSocket(8080);
        String str = "fkd";
        //将数据包发送到8090口
        DatagramPacket packet = new DatagramPacket(str.getBytes(),0,str.length(), InetAddress.getByName("localhost"),8090);
        server.send(packet);
        System.out.println("消息发送完毕....");
        server.close();
    }
}
