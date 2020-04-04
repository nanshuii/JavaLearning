package test;

/*
* 递归
* 直接递归
* 方法自身调用自己
* 简介递归
* A调用B B调用C C调用A
*
* 递归需要有停止的条件
* 构造方法禁止递归
*
*
*
* */

import java.io.File;
import java.util.Arrays;

public class RecursiveDemo {
    public static void main(String[] args) {
        System.out.println(test001(100));
        System.out.println(test002(4));
        System.out.println("=================");
        test003(new File("com/test/demo"));
        System.out.println("=================");
    }

    // 直接递归 计算1-n之间的和
    public static int test001(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + test001(n-1);
        }
    }

    // 直接递归 计算1-n之间的乘积
    public static int test002(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * test002(n-1);
        }
    }

    // 直接递归 打印一个目录下所有java文件
    public static void test003(File file) {
        if (file.isDirectory()) {
            // 是一个目录
            File[] files = file.listFiles();
            for (File file1 : files) {
                String fileString = file1.toString().toLowerCase();
                if (file1.isFile() && fileString.endsWith(".java")) {
                    System.out.println(fileString);
                }
                test003(file1);
            }
        }
    }
}
