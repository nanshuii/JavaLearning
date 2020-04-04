package test;

/*
* IO
* public void close() 关闭此输出流并释放与此流相关联的任何系统资源
* public void flush() 刷新此输出流并强制任何缓冲的输出字节被写出
* public void write(byte[] b) 将b.length字节从指定的字节数组写入此输出流
* public void write(byte[] b, int off, int len) 从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
* public void abstract void write(int b) 将指定的字节输出流
*
* FileOutputStream extends OutputStream 文件字节输出流
* 把内存中的数据写入到硬盘的文件中
*
* 构造方法：
* FileOutputStream(String name)
* 创建一个向具有指定名称的文件中写入数据的输出文件流
* FileOutputStream(File file)
* 创建一个向指定File对象表示的文件中写入数据的文件输出流
*
* 创建一个FileOutputStream对象；
* 根据文件/文件路径，创建一个空的文件
* 将FileOutputStream对象指向创建好的文件
*
* 写入数据的原理（内存-->硬盘）
* java程序-->JVM-->OS-->OS调用写数据的方法-->把数据写入到文件中
* 步骤：
* 创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
* 调用FileOutputStream对象中的方法write，把数据写入到文件中
* 释放资源
*
* */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) throws IOException {
        test01();
    }

    // 由内存写入硬盘实例
    public static void test01() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("com/test/demo/test01.txt");
        fileOutputStream.write(2088); // 写入一个字节100
        fileOutputStream.close(); // 释放资源
    }
}
