package bstest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/*
* BS版本TCP服务器
* */
public class tcpserver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 把网络字节输入流对象转换为字符缓冲输入流
                        InputStream inputStream = socket.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                        // 读取客户端请求信息(http://127.0.0.1:8080/web/index.html)的第一行数据
                        // 切割读取的部分(GET /web/index.html HTTP/1.1)只需要读取/web/index.html这一部分
                        String line = bufferedReader.readLine();
                        System.out.println(line);
                        String[] arr = line.split(" "); // 分割成三部分
                        String htmlPath = arr[1].substring(1); // 取其中的一部分，去除最前面的/

                        // 根据本地读取到的文件，写入到网络字节输出流中
                        FileInputStream fileInputStream = new FileInputStream(htmlPath);
                        OutputStream outputStream = socket.getOutputStream();
                        // 写入HTTP协议响应头;必须写入空行，否则浏览器不解析
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content-Type:text/html\r\n".getBytes());
                        outputStream.write("\r\n".getBytes());
                        // 本地文件的写入
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        if ((len = fileInputStream.read(bytes)) != -1) {
                            outputStream.write(bytes);
                        }
                        // 释放资源
                        fileInputStream.close();
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
