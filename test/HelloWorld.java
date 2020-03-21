import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import com.test.demo.test001;
import com.test.demo.Test003;

import javax.xml.namespace.QName;

// 定义一个类的名称 HelloWorld
public class HelloWorld {
	// main 方法 代表程序执行的起点
	public static void main(String[] args) {
		System.out.println("Hello World!");
		test008();
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

	/* random 随机数的生成
	*
	* 初始化
	* Random random = new Random();
	*
	* 使用
	* 获取一个随机int，int num = random.nextInt(); 这个时候范围是int的范围，有正负
	* 获取一个随机int，int num = random.nextInt(3); 这个时候范围是0~2
	*
	* */
	public static void test005() {
		Random random = new Random();

		int num = random.nextInt();
		System.out.println("random = " + num);

		for (int i = 0; i < 100; i++) {
			int n = random.nextInt(10);
			System.out.print(" " + n);
		}
	}
	// 练习：random猜数字
	public static void test006() {
		Random random = new Random();
		int num = random.nextInt(100) + 1;
		Scanner scanner = new Scanner(System.in);
		int inputNum = 0;
		System.out.println("开始猜数字");
		while (true) {
			inputNum = scanner.nextInt();
			if (inputNum == num) {
				System.out.println("猜中了");
				break;
			} else if (inputNum > num) {
				System.out.println(inputNum + " 太大了");
			} else {
				System.out.println(inputNum + " 太小了");
			}
		}
	}

	/*
	* ArrayList
	* 数组的长度不可改变，ArrayList的长度可以随意变化
	* 对于ArrayList直接打印，打印内容，内容为空则为[]
	*
	* 初始化
	* ArrayList<E> E代表泛型，表示类型；泛型不可以是引用类型
	* String类型的ArrayList ArrayList<String> list = new ArrayList<>();
	*
	* 使用（常用方法）
	* add 添加，返回值boolean
	* get(index) 读取
	* remove(index or object) 移除 如果是object，选择序列号最小的一个object进行删除，返回值是boolean；如果是index，超出就报错，返回一个object；
	* size() 长度，返回int长度
	*
	* */
	public static void test007() {
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("1");
		list.add("2");
		System.out.println(list.add("2"));
		list.add("1");
		System.out.println(list);
		String gStr = list.get(0);
		System.out.println(gStr);
		boolean rStr = list.remove("3");
		System.out.println("remove " + rStr);
		rStr = list.remove("2");
		System.out.println("remove " + rStr);
		String rS = list.remove(0);
		System.out.println("remove " + rS);
		System.out.println(list);
		int size = list.size();
		System.out.println("size = " + size);
	}
	
	// 练习：生成6个1-33之间的随机整数，添加到集合，并遍历集合
	public static void test008() {
		Random random = new Random();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			int num = random.nextInt(33) + 1;
			list.add(num);
		}
        for (Integer integer : list) {
            System.out.println(integer);
        }
	}
}

