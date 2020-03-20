import java.util.Arrays;
import java.util.Scanner;
import com.test.demo.test001;
import com.test.demo.Test003;

import javax.xml.namespace.QName;

// 定义一个类的名称 HelloWorld
public class HelloWorld {
	// main 方法 代表程序执行的起点
	public static void main(String[] args) {
		System.out.println("Hello World!");
//		function1();
//        int num = function2(1, 2);
//        System.out.println(num);
//        System.out.println(sum(1 ,2));
//        System.out.println(sum(1, 2, 3));
//        System.out.println(sum(1, 2, 3, 4));
        // 对象的创建和调用
//        test001 test = new test001();
//        test.test();
//        System.out.println(test.age);
//        test001();

//		Test003 test = new Test003();
//		Test003 test2 = new Test003("1", 2);
//		System.out.println(test2.getName());
//		System.out.println(test2.getAge());

		test004();
	}

	// 练习：方法重载
	public static void function1() {
		System.out.println("hi");
	}

	public static int function2(int num1, int num2) {
	    return num1 + num2;
    }

    public static int sum(int a, int b) {
		return a + b;
	}

	public static int sum(int a, int b, int c) {
		return a + b + c;
	}

	public static int sum(int a, int b, int c, int d) {
		return a + b + c + d;
	}

	// 练习：数组置换
    public static void test001() {
	    int[] array = {1, 2, 3, 4, 5};
	    int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println(Arrays.toString(array));

    }

	/*
	* 练习：Scanner键盘输入
	*
	* 创建时候
	* 初始化System.in表示从键盘输入
	*
	* 使用
	* 获取键盘输入的int数字，int num = scanner.nextInt();
	* 获取键盘输入的String字符串，String str = scanner.next();
	*/
	public static void test002() {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println("输入的数字是：" + num);
		String str = scanner.next();
		System.out.println("输入的字符串是：" + str);
	}

	// 练习：Scanner输入两个int数字，输出相加值
	public static void test003() {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		System.out.println(num1 + num2);
	}

	// 练习：Scanner输入三个int数字，输出最大值
	public static void test004() {
		Scanner scanner = new Scanner(System.in);
		int num;
		int num1 = scanner.nextInt();
		num = num1;
		int num2 = scanner.nextInt();
		if (num2 > num) {
			num = num2;
		}
		int num3 = scanner.nextInt();
		if (num3 > num) {
			num = num3;
		}
		System.out.println("三个数字的最大值：" + num);
	}

}

