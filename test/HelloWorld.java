// 定义一个类的名称 HelloWorld
public class HelloWorld {
	// main 方法 代表程序执行的起点
	public static void main(String[] args) {
		System.out.println("Hello World!");
//		function1();
        int num = function2(1, 2);
        System.out.println(num);

        System.out.println(sum(1 ,2));
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(1, 2, 3, 4));
	}

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
}

