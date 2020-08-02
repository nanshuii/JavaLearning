package com.test.demo.net.test01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
* 文件上传案例客户端：读取本地文件，上传到服务器，读取服务器回写的数据
*
* 数据源：res/tcptest01client/01.jpeg
* 目的地：服务器
*
* 实现步骤：
*   1。创建一个本地字节输入流FileInputStream对象，构造房中绑定要读取的数据源
*   2。创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
*   3。使用Socket对象中的getOutputStream方法，获取网络字节输出流OutputStream对象
*   4。使用本地字节输入流FileInputStream对象中的方法read，读取本地文件
*   5。使用网络字节输出流OutputStream对象中的方法write方法，把读取到的文件上传到服务器
*   6。使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
*   7。使用网络字节输入流InputStream对象中的方法read读取服务器回写的数据
*   8。释放资源（FileInputStream, Socket）
* */
public class tcpclient {
    public static void main(String[] args) throws IOException {
        // 1.创建一个本地字节输入流FileInputStream对象，构造房中绑定要读取的数据源
        FileInputStream fileInputStream = new FileInputStream("res/tcptest01client/01.jpeg");
        // 2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        // 3. 使用Socket对象中的getOutputStream方法，获取网络字节输出流OutputStream对象
        OutputStream outputStream = socket.getOutputStream();
        // 4. 使用本地字节输入流FileInputStream对象中的方法read，读取本地文件
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            // 5.使用网络字节输出流OutputStream对象中的方法write方法，把读取到的文件上传到服务器
            outputStream.write(bytes, 0, len);
        }
        // 阻塞解决：上传完文件给服务器写一个结束标记；对于TCP套接字，任何以前写入的数据都将发送，并且后跟TCP正常连接终止序列
        socket.shutdownOutput();
        // 6.使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
        InputStream inputStream = socket.getInputStream();
        // 7.使用网络字节输入流InputStream对象中的方法read读取服务器回写的数据
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        // 8.释放资源（FileInputStream, Socket）
        fileInputStream.close();
        socket.close();
    }
}
