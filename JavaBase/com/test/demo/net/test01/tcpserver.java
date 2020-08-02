package com.test.demo.net.test01;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
 * 文件上传案例服务器：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写'上传成功'
 *
 * 数据源：客户端上传的文件
 * 目的地：res/tcptest01server
 *
 * 实现步骤：
 *  1。创建一个服务器ServerSocket对象
 *  2。使用ServerSocket对象中的方法accept，获取请求的客户端对象Socket
 *  3。使用Socket对象中的方法getInputSream，获取网络字节输入流InputStream对象
 *  4。判断目的地目录是否存在，不存在则创建
 *  5。创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
 *  6。使用网络字节输入流InputStream对象中方法read，读取客户端上传的文件保存到服务器的硬盘上
 *  7。使用本地字节输出流FileOutputStream对象中的方法write，把读取到的文件保存到服务器的硬盘上
 *  8。使用Socket对象中的方法getOutputStream，获取网络字节输出流OutputStream对象
 *  9。使用网络字节输出流OutputStream对象中的方法write，给客户端回写'上传成功'
 *  10。释放资源（FileOutputStream, Socket, ServerSocket）
 * */
public class tcpserver {
    public static void main(String[] args) throws IOException {
        // 1.创建一个服务器ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        // 服务器一直处于监听状态
        while (true) {
            // 2.使用ServerSocket对象中的方法accept，获取请求的客户端对象Socket
            Socket socket = serverSocket.accept();
            // 使用多线程提高程序效率
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 完成文件的上传
                    // 此时无法抛出异常，使用try-catch
                    try {
                        // 3.使用Socket对象中的方法getInputSream，获取网络字节输入流InputStream对象
                        InputStream inputStream = socket.getInputStream();
                        // 4.判断目的地目录是否存在，不存在则创建
                        File file = new File("res/tcptest01server");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        // 自定义文件命令规则，防止同名文件被覆盖
                        String fileName = "ledon" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
                        // 5.创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
                        FileOutputStream fileOutputStream = new FileOutputStream(file + "/" + fileName);
                        // 6.使用网络字节输入流InputStream对象中方法read，读取客户端上传的文件保存到服务器的硬盘上
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = inputStream.read(bytes)) != -1) {
                            // 7.使用本地字节输出流FileOutputStream对象中的方法write，把读取到的文件保存到服务器的硬盘上
                            fileOutputStream.write(bytes, 0, len);
                        }
                        // 8.使用Socket对象中的方法getOutputStream，获取网络字节输出流OutputStream对象
                        // 9.使用网络字节输出流OutputStream对象中的方法write，给客户端回写'上传成功'
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("上传成功".getBytes());
                        // 10.释放资源（FileOutputStream, Socket, ServerSocket）
                        fileOutputStream.close();
                        socket.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }).start();



        }
//        serverSocket.close();
    }
}
