package com.dynamic.bill4j.io.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/3/12
 */
public class GreetClient {
    public static void main(String[] args) throws IOException {
    //创建套接字对象，和目标对象建立连接,交换套接字信息（控制信息：ip、端口号、连接的状态、建立连接的时间，协议，进程号等）
        System.out.println("连接到远程主机：localhost , 端口为 ：6066");
        Socket client = new Socket("localhost", 6066);
        System.out.println("远程主机的地址："+client.getRemoteSocketAddress());
        //    发送请求消息给目标对象
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
        dataOutputStream.writeUTF("您好啊，服务器先生，我是："+client.getLocalSocketAddress());
    //    接收服务器返回的数据
        DataInputStream inputStream = new DataInputStream(client.getInputStream());
        System.out.println(inputStream.readUTF());
        client.close();

    }
}
