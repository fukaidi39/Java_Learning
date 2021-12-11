package zju.web.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Autor:godfu
 * @Date:2021/12/10-21:42
 */
public class UDPClient {
    public static void main(String[] args) throws Exception{
        //连接到8090端口
        DatagramSocket client = new DatagramSocket(8090);
        byte data[] = new byte[1024];//接受信息
        DatagramPacket packet = new DatagramPacket(data, data.length);
        System.out.println("客户端等待接受发送的消息.....");
        //接受消息，保存在data数组中
        client.receive(packet);
        System.out.println("接收到的消息为："+ new String(data,0, data.length));
        client.close();
    }
}
