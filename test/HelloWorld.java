import java.util.Arrays;
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


}

