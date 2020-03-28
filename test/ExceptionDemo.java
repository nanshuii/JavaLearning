package test;

import com.test.demo.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 异常
* Exception 编译期异常
* RuntimeException 运行期异常
*
* throw
* 可以抛出指定异常
* throw new xxxException("异常产生的原因")
* xxxException必须是exception或者exception的子对象
* throw创建的是编译异常，必须处理
*
* throws
* throw创建的是runtime exception对象或子对象，可以不处理
* 在方法名末尾添加要抛出的异常 throws ......
* 如果有多个异常，全部都要抛出来
* 如果抛出来的异常，有父子类关系，只要抛出父类异常即可；比如 FileNotFoundException和IOException 只要抛出IOException
*
* try-catch
* 抛出异常，后续代码可以继续运行
* 一个try可以对应多个catch，捕获多个异常
*
* finally
* 无论是否出现异常都会执行
* 必须和try一起使用
* 一般用于资源回收
*
*
*
*
* */
public class ExceptionDemo {
    public static void main(String[] args) throws IOException {
//        exceptionTest();

//        runtimeExceptionText();

//        int[] arr = new int[3];
//        int element = throwText(arr, 4);
//        System.out.println(element);

//        throwsTest("C:");
//        System.out.println("后续代码");

        finallyTest();
    }

    // 编译期异常
    public static void exceptionTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse("1900-0909");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        System.out.println("try-catch 抛出异常，后续代码可以继续运行");
    }

    // 运行期异常
    public static void runtimeExceptionText() {
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[10]);
        } catch (Exception e) {
            System.out.println("runtime exception = " + e);
        }
        System.out.println("---");
    }

    // throw 运行异常
    public static int throwText(int[] arr, int index) {
        if (arr == null) {
            throw new NullPointerException("传递的数组为null");
        }

        if (index > arr.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("数组索引越界");
        }

        return arr[index];
    }

    // throws 编译异常
    public static void throwsTest(String filename) throws IOException{
        if (!filename.equals("C:")) {
            throw new FileNotFoundException("文件未找到");
        }
        if (!filename.endsWith(".txt")) {
            throw new IOException("文件后缀名不正确");
        }
    }

    // finally
    public static void finallyTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse("1900-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("不管怎么样都会执行的代码");
        }
        System.out.println(date);
        System.out.println("try-catch 抛出异常，后续代码可以继续运行");
    }
}


