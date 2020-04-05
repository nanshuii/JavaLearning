package test;

/*
* IO
*
* 字节输出
*
* OutputStream()
*
* public void close()
* 关闭此输出流并释放与此流相关联的任何系统资源
*
* public void flush()
* 刷新此输出流并强制任何缓冲的输出字节被写出
*
* public void write(byte[] b)
* 将b.length字节从指定的字节数组写入此输出流
* 如果写入的byte数组中第一个字节是正数（0-127），那么显示的时候会调用ASCII表
* 如果写入的byte数组中第一个字节是负数，第一个字节会和第二个字节组合成一个中文，显示的时候调用系统码表
*
* public void write(byte[] b, int off, int len)
* 从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
*
* public void abstract void write(int b)
* 将指定的字节输出流
*
* FileOutputStream extends OutputStream 文件字节输出流
* 把内存中的数据写入到硬盘的文件中
*
* 构造方法：
* FileOutputStream(String name)
* 创建一个向具有指定名称的文件中写入数据的输出文件流
*
* FileOutputStream(File file)
* 创建一个向指定File对象表示的文件中写入数据的文件输出流
*
* FileOutputStream(String name, boolean append)
* 创建一个向具有指定name的文件中写入数据的输出文件夹流
* append true 创建对象不会覆盖原文件，继续在文件的末尾追加写数据
* append false 创建对象会覆盖原文件
*
* FileOutputStream(File file, boolean append)
* 创建一个向指定File对象表示的文件中写入数据的文件输出流
* append true 创建对象不会覆盖原文件，继续在文件的末尾追加写数据
* append false 创建对象会覆盖原文件
*
* 换行符号
* windows \r\n
* linux \n
* mac \r
*
*
*
*
* 字节输入
*
* InputStream()
*
* public int read()
* 从输入流中读取数据的下一个字节
* 读取到文件的末尾返回-1
*
* public int read(byte[] b)
* 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
* 一般byte数组存储1024倍数的长度，1kb
* int 返回的是byte数组中的真实字节数量
* 可以使用String类型的构造把读取的字节转换成String
* String string = new String(bytes, 0, len);
*
* public void close()
* 关闭此输入流并释放与该流关联的所有系统资源
*
* FileInputStream extends InputStream 文件字节输入流
* 把硬盘文件中的数据，读取到内存中使用
*
* 构造方法
* FileInputStream(String name)
* FileInputStream(File file)
*
*
*
*
* 字符输入
*
* Reader()
*
* public int read()
* 读取单个字符
* 读取到文件的末尾返回-1
*
* public int read(char[] cbuf)
* 读取多个字符进入数组
*
* public void close()
* 关闭释放文件资源
*
*
*
* FileReader() extends InputStreamReader extends Reader 文件字符输入流
* 把硬盘文件中的数据以字符的方式读取到内存中
*
* 构造方法
* FileReader(String filename)
* FileReader(File file)
*
*
*
* 字符输出
*
* Writer()
*
* public void write(int c) 写入字符
* public void write(char[] cbuf) 写入字符数组
* public abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分，off 数组的开始索引，len 写的字符个数
* public void write(String string) 写入字符串
* public void write(String string, int off, int len) 写入字符串的某一部分，off 字符串的开始索引，len 写的字符个数
* public void flush() 刷新该流的缓存
* public void close() 关闭此流，但要先刷新
*
*
* FileWriter() extends OutputStreamWriter extends Writer 文件字符输出流
* 把内存中的字符写入到文件夹中
*
* 构造方法
* FileWriter(String filename)
* FileWriter(File file)
* 写入的时候是写入到内存缓冲区，写完之后flush，也可以是直接close（也做了刷新操作）
*
*
*
*
* */

import java.io.*;
import java.util.Arrays;

public class IODemo {
    public static void main(String[] args) throws IOException {
        test12();
    }

    // 由内存写入硬盘
    public static void test01() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("com/test/demo/test01.txt");
        fileOutputStream.write(2088); // 写入一个字节100
        fileOutputStream.close(); // 释放资源
    }

    // 由内存写入多个字节
    public static void test02() throws IOException {
        byte[] bytes = {49, 48, 48};
        byte[] bytes1 = {65, 66, 67, 68, 69};
        FileOutputStream fileOutputStream = new FileOutputStream("com/test/demo/test01.txt");
        fileOutputStream.write(bytes);
        fileOutputStream.write(bytes1);
        fileOutputStream.close();
    }

    // 追加写
    public static void test03() throws  IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("com/test/demo/test01.txt", true);
        fileOutputStream.write("追加写数据 不覆盖".getBytes());
        fileOutputStream.close();

        FileOutputStream fileOutputStream1 = new FileOutputStream("com/test/demo/test02.txt", false);
        fileOutputStream1.write("追加写数据 覆盖".getBytes());
        fileOutputStream1.close();

        FileOutputStream fileOutputStream2 = new FileOutputStream("com/test/demo/test01.txt", true);
        for (int i = 0; i < 5; i++) {
            fileOutputStream2.write("换行写入\r".getBytes());
        }
        fileOutputStream2.close();

    }

    // 读取单个字节
    public static void test04() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("com/test/demo/test02.txt");
        int len = 0;
        while (len != -1) {
            len = fileInputStream.read();
            System.out.println(len);
        }
        fileInputStream.close();
    }

    // 读取多个字节
    public static void test05() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("com/test/demo/test02.txt");
        byte[] bytes = new byte[1024]; //
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(len);
            String string = new String(bytes, 0, len);
            System.out.println(string);
        }
        fileInputStream.close();
    }

    // 复制一个图片
    public static void test06() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("com/test/demo/testImage.png");
        FileOutputStream fileOutputStream = new FileOutputStream("com/test/demo/testImage2.png");
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    // FileReader read
    public static void test07() throws IOException {
        FileReader fileReader = new FileReader("com/test/demo/test02.txt");
        int len;
        while ((len = fileReader.read()) != -1) {
            System.out.print((char)len);
        }
        fileReader.close();
    }

    // FileReader read
    public static void test08() throws IOException {
        FileReader fileReader = new FileReader("com/test/demo/test02.txt");
        char[] chars = new char[1024];
        int len;
        while ((len = fileReader.read(chars)) != -1) {
            System.out.println(len);
            String string = new String(chars, 0, len);
            System.out.println(string);
        }
        fileReader.close();
    }

    // FilerWriter
    public static void test09() throws IOException {
        FileWriter fileWriter = new FileWriter("com/test/demo/test03.txt");
        fileWriter.write(97);
//        fileWriter.flush();
        fileWriter.close();

        FileWriter fileWriter1 = new FileWriter("com/test/demo/test03.txt");
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        fileWriter1.write(chars);
        fileWriter1.write("字符串");
        fileWriter1.close();

        FileWriter fileWriter2 = new FileWriter("com/test/demo/test04.txt");
        fileWriter2.write(chars, 1, 3);
        fileWriter2.write("xxxxx写字符串的一部分xxxxx", 5, 8);
        fileWriter2.close();
    }

    // try-catch-finally处理异常
    public static void test10() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("faker/test/demo/test05.txt", false);
            for (int i = 0; i < 10; i++) {
                fileWriter.write("hhhhhh");
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // JDK7 try-catch try()之后定义流对象，try之后会自动释放
    public static void test11() {
        try(FileWriter fileWriter = new FileWriter("faker/com.txt")) {
            for (int i = 0; i < 10; i++) {
                fileWriter.write("hhhhhh");
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // JDK9 tyr-catch try前面可以定义，try()引用变量名，try执行完毕之后会自动释放
    public static void test12() throws IOException {
        FileWriter fileWriter = new FileWriter("faker/com.txt");
        try(fileWriter) {
            for (int i = 0; i < 10; i++) {
                fileWriter.write("hhhhhh");
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
