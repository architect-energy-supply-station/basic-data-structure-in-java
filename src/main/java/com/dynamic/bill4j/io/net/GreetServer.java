package com.dynamic.bill4j.io.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/3/12
 */
public class GreetServer implements Runnable{

    private ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        GreetServer server = new GreetServer(6066);
        server.run();
    }
    public GreetServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort());
            try {
                //建立连接，获取套接字内容，写入内容到套接字，交换控制信息
                Socket server = serverSocket.accept();
                System.out.println("请求连接的远程主机地址为：" + server.getRemoteSocketAddress());
                //获取输入流（从客户端来的请求消息）
                DataInputStream inputStream = new DataInputStream(server.getInputStream());
                System.out.println(inputStream.readUTF());
                //获取输出流对象（将从服务端，返回到客户端的数据流）
                DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
                //写入返回给客户端的消息
                outputStream.writeUTF("感谢您连接：" + server.getLocalSocketAddress());
                //关闭服务端端
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
