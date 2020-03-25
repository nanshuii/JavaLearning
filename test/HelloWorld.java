import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.test.demo.*;

import javax.xml.namespace.QName;

// 定义一个类的名称 HelloWorld
public class HelloWorld {
	// main 方法 代表程序执行的起点
	public static void main(String[] args) throws ParseException {
		System.out.println("Hello World!");
		test018();
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

	// 练习：键盘输入一个字符串，并且统计其中各种字符出现的次数，种类有大写字母，小写字母，数字，其他
    public static void test009() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("请输入一串字符串：");
	    String str = scanner.next();
	    System.out.println("start........");
	    int upper = 0;
	    int lower = 0;
	    int number = 0;
	    int other = 0;
	    char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if ('A' <= ch && 'Z' >= ch) {
                upper++;
            } else if ('a' <= ch && 'z' >= ch) {
                lower++;
            } else if ('0' <= ch && '9' >= ch) {
                number++;
            } else {
                other++;
            }
        }
        System.out.println("upper = " + upper + " lower = " + lower + " number = " + number + " other = " + other);
    }

    // 练习：static关键字
    public static void test010() {
	    Test004 test1 = new Test004("roll", 12);
	    Test004 test2 = new Test004("gill", 14);
	    test1.room = "101";
	    System.out.println("test1 name = " + test1.getName() + " age = " + test1.getAge() + " room = " + test1.room + " id = " + test1.getId());
        System.out.println("test2 name = " + test2.getName() + " age = " + test2.getAge() + " room = " + test2.room + " id = " + test2.getId());

        test1.method();
        Test004.staticMethod();
    }

    /*
    * Math
    * public static double abs(double num); 获取绝对值
    * public static double ceil(double num); 向上取整 1.1-->2.0
    * public static double floor(double num); 向下取整 1.9-->1.0
    * public static long round(double num); 四舍五入
    * Math.PI
    *
    * */
    public static void test011() {
        System.out.println(Math.abs(-111));
        System.out.println(Math.ceil(1.1));
        System.out.println(Math.floor(1.9));
        System.out.println(Math.round(1.99));
    }

    // 练习：继承
	public static void test012() {
		Test005 test = new Test005();
		test.method();
		System.out.println(test.numF);

    	Test006 test1 = new Test006();
    	test1.method();
    	System.out.println(test1.numF + test1.numZ);

    	System.out.println("=============================");

    	System.out.println(test1.num); // 访问子类的num
    	System.out.println(test1.numF); // 访问父类的numF

		System.out.println("=============================");

		test1.methodZ();
		test1.methodF();
		test1.method();

	}

	// 练习：抽象
	public static void test013() {
    	Test008 test = new Test008();
    	test.method();
	}

	// 练习：接口
	public static void test014() {
    	Test010 test = new Test010();
    	test.absMethod();
    	test.absMethod2();
    	test.defaultMethod();

    	Test009.staticMethod();

    	System.out.println(test.NUM);

    	test.method();

	}

	// 练习：内部类
	public static void test015() {
    	Test012.Test0121 test1 = new Test012().new Test0121();
    	test1.methodInsert();
    	System.out.println("======================");
    	Test012 test = new Test012();
    	test.methodInsertUsed();
		System.out.println("======================");
	}

	// 练习：匿名内部类
	public static void test016() {
    	Test011 test = new Test011() {
			@Override
			public void method() {
				System.out.println("匿名内部类实现方法 method");
			}

			@Override
			public void absMethod() {
				System.out.println("匿名内部类实现方法 abstract method");
			}
		};

    	test.method();
    	test.absMethod();
    	test.defaultMethod();

    	new Test011() {
			@Override
			public void method() {
				System.out.println("匿名对象 method");
			}

			@Override
			public void absMethod() {

			}
		}.method();
	}


	/*
	* Date
	* Date精确到毫秒
	*
	* 初始化
	* Date date = new Date(0L); Thu Jan 01 08:00:00 CST 1970
	* Date date = new Date(); 当前时间 Wed Mar 25 16:04:38 CST 2020
	* Date date2 = new Date(1585123477934L); 根据时间戳来转换时间 Wed Mar 25 16:04:37 CST 2020
	*
	* 常用方法
	* getTime(); 返回时间戳 long timestamp = date1.getTime();
	*
	*
	* DateFormat
	* 
	* 初始化
	* yyyy-MM-dd HH-mm-ss 年月日时分秒
	* SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	*
	* 格式化 日期转为文本
	* String formatStr = format.format(date1);
	* System.out.println(formatStr); // 2020-03-25 16-47-51
	* 解析 文本转为日期
	* Date date4 = format.parse(formatStr);
	* System.out.println(date4); // Wed Mar 25 16:47:51 CST 2020
	*
	* Calendar
	* 初始化 Calendar calendar = Calendar.getInstance();
	*
	* 常用方法
	* 获取其中的一个参数值 get 返回 int
	* 可以获取年月日时分秒
	* System.out.println("year = " + calendar.get(Calendar.YEAR));
	* System.out.println("month = " + calendar.get(Calendar.MONDAY)); // 月份0-11
	* System.out.println("dayOfMonth = " + calendar.get(Calendar.DAY_OF_MONTH)); // 一个月中的某一天
	* System.out.println("date = " + calendar.get(Calendar.DATE)); // 等同于DAY_OF_MONTH
	* System.out.println("hour = " + calendar.get(Calendar.HOUR));
	* System.out.println("minute = " + calendar.get(Calendar.MINUTE));
	* System.out.println("second = " + calendar.get(Calendar.SECOND));
	*
	* 设置一个值给制定的字段 年月日时分秒
	* calendar.set(Calendar.YEAR, 2088);
	*
	* 设置一个值给制定的指端，用来增加和减少 年月日时分秒
	* 可以是增加或是减少
	* calendar.add(Calendar.YEAR, -100);
	*
	* 把日历对象转换成日期对象
	* Date date5 = calendar.getTime();
	*
	* */
	public static void test017() throws ParseException {

		Date date = new Date(0L);
		System.out.println(date);

		Date date1 = new Date();
		System.out.println(date1);

		Date date2 = new Date(1585123477934L);
		System.out.println(date2);

		long timestamp = date1.getTime();
		System.out.println(timestamp);

		System.out.println("==========================");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String formatStr = format.format(date1);
		System.out.println(formatStr); // 2020-03-25 16-47-51
		Date date4 = format.parse(formatStr);
		System.out.println(date4); // Wed Mar 25 16:47:51 CST 2020

		System.out.println("==========================");

		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);

		System.out.println("year = " + calendar.get(Calendar.YEAR));
		System.out.println("month = " + calendar.get(Calendar.MONDAY)); // 月份0-11
		System.out.println("dayOfMonth = " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("date = " + calendar.get(Calendar.DATE));
		System.out.println("hour = " + calendar.get(Calendar.HOUR));
		System.out.println("minute = " + calendar.get(Calendar.MINUTE));
		System.out.println("second = " + calendar.get(Calendar.SECOND));

		calendar.set(Calendar.YEAR, 2088);
		System.out.println("year = " + calendar.get(Calendar.YEAR));

		calendar.add(Calendar.YEAR, -100);
		System.out.println("year = " + calendar.get(Calendar.YEAR));

		Date date5 = calendar.getTime();
		System.out.println(date5);

	}

	/*
	* System类
	*
	* System.currentTimeMillis();
	* 返回以毫秒值为单位的当前时间，可以用来获取一个操作使用的时间
	*
	* System.arrayCopy(src 要复制的原数组，secpos 原数组的起始索引位置， dest 目标数组，destpos 目标数组的起始索引位置， length 要复制的数组元素的数量);
	*
	* */
	public static void test018() {
		System.out.println(System.currentTimeMillis()); // 返回以毫秒值为单位的当前时间，可以用来获取一个操作使用的时间

		int[] src = {1, 2, 3, 4, 5};
		int[] dest = {6, 7, 8, 9 , 10};
		System.out.println("复制前：" + Arrays.toString(dest)); // [6, 7, 8, 9, 10]
		System.arraycopy(src, 0 , dest, 0, 3);
		System.out.println("复制后：" + Arrays.toString(dest)); [1, 2, 3, 9, 10]

	}
}

