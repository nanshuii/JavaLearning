## 目录
#### Scanner键盘输入
#### Random随机数
#### ArrayList
#### static
#### Math
#### final
#### 内部类
#### 和日期相关的类
#### System类

------
## Scanner键盘输入
#### 创建时候
初始化System.in表示从键盘输入

#### 使用
获取键盘输入的int数字，int num = scanner.nextInt();

获取键盘输入的String字符串，String str = scanner.next();

#### 示例
```$xslt
Scanner scanner = new Scanner(System.in);
int num = scanner.nextInt();
System.out.println("输入的数字是：" + num);
String str = scanner.next();
System.out.println("输入的字符串是：" + str);
```
## Random随机数
#### 创建
Random random = new Random();

#### 使用
获取一个随机int，int num = random.nextInt(); 这个时候范围是int的范围，有正负
获取一个随机int，int num = random.nextInt(3); 这个时候范围是0~2

#### 示例
```$xslt
Random random = new Random();

int num = random.nextInt();
System.out.println("random = " + num);

for (int i = 0; i < 100; i++) {
    int n = random.nextInt(10);
    System.out.print(" " + n);
}
```

猜随机数，使用Scanner和Random
```$xslt
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
```
----
## ArrayList
数组的长度不可改变，ArrayList的长度可以随意变化
对于ArrayList直接打印，打印内容，内容为空则为[]
#### 初始化
ArrayList<E> E代表泛型，表示类型；泛型不可以是引用类型
String类型的ArrayList ArrayList<String> list = new ArrayList<>();
#### 使用（常用方法）
add 添加，返回值boolean
get(index) 读取
remove(index or object) 移除 如果是object，选择序列号最小的一个object进行删除，返回值是boolean；如果是index，超出就报错，返回一个object；
size() 长度，返回int长度
#### 示例
```
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
```
----
## static
#### 变量
如果一个成员变量使用了static关键字，那么这个变量不再输入对象自己，而是属于所在的类。多个对象共享同一个数据。
#### 方法
如果一个成员方法使用了static关键字，那么这个方法成为静态方法，属于类不属于对象。
成员方法必须创建对象才能使用。
静态方法可以只过通过类名称来调用
#### 内存中先生成静态再生成非静态
成员方法可以访问成员变量和静态变量
静态方法不可以访问成员变量
#### 静态代码块 
static{ // 静态代码块内容 }
静态代码块是第一次使用类时调用，只执行一次
静态代码块比构造方法执行更早
用来一次性的对静态变量成员进行赋值
----
## Math
public static double abs(double num); 获取绝对值
public static double ceil(double num); 向上取整 1.1-->2.0
public static double floor(double num); 向下取整 1.9-->1.0
public static long round(double num); 四舍五入
Math.PI 
----
## final
对于类和方法，final和abstract不可以同时使用

#### final修饰一个类
public final class 类名称{ //...... }
这个类不可以有子类

#### final修饰一个方法
final 返回值类型(){ //...... }
这个方法不能被覆盖重写

#### final修饰一个局部变量
final 类型 名称
局部变量不能进行更改
对于引用类型来说，地址值不可改变；里面的内容可以改变

#### final修饰一个成员变量
final 类型 名称
成员变量不能进行改变
用了final之后必须进行赋值，直接赋值或是用构造方法赋值（用了直接赋值之后不可以使用构造赋值）
-----
## 内部类
成员内部类
局部内部类（包含匿名内部类）
内部类可以访问内部的变量和方法
外部访问内部类需要实例化内部类对象

#### 使用方式
间接使用
在外部类的方法中，实例化内部类对象，调用内部类方法

直接使用
外部类.内部类 名称 = new 外部类().new 内部类()
Test012.Test0121 test1 = new Test012().new Test0121();

#### 当内部类成员变量和外部类成员变量名字相同时候
内部类方法内部变量 num
内部类成员变量 this.num
外部类成员变量 外部类的名字.this.num

#### 局部内部类想要访问所在方法的局部变量
需要final标识（如果不变，可以省略）

#### 匿名类
只需要使用一次，免除接口实现类 接口 接口名称 = new 接口() { 里面覆盖重写接口的抽象方法 }

```
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
```
----
## 和日期相关的类
#### Date
Date精确到毫秒

##### 初始化
Date date = new Date(0L); Thu Jan 01 08:00:00 CST 1970
Date date = new Date(); 当前时间 Wed Mar 25 16:04:38 CST 2020
Date date2 = new Date(1585123477934L); 根据时间戳来转换时间 Wed Mar 25 16:04:37 CST 2020

##### 常用方法
###### getTime(); 
返回时间戳 long timestamp = date1.getTime();

#### DateFormat
##### 初始化
yyyy-MM-dd HH-mm-ss 年月日时分秒
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

##### 格式化 日期转为文本
String formatStr = format.format(date1);
System.out.println(formatStr); // 2020-03-25 16-47-51

##### 解析 文本转为日期
Date date4 = format.parse(formatStr);
System.out.println(date4); // Wed Mar 25 16:47:51 CST 2020

#### Calendar
##### 初始化 
Calendar calendar = Calendar.getInstance();

##### 常用方法
获取其中的一个参数值 get 返回 int
可以获取年月日时分秒
System.out.println("year = " + calendar.get(Calendar.YEAR));
System.out.println("month = " + calendar.get(Calendar.MONDAY)); // 月份0-11
System.out.println("dayOfMonth = " + calendar.get(Calendar.DAY_OF_MONTH)); // 一个月中的某一天
System.out.println("date = " + calendar.get(Calendar.DATE)); // 等同于DAY_OF_MONTH
System.out.println("hour = " + calendar.get(Calendar.HOUR));
System.out.println("minute = " + calendar.get(Calendar.MINUTE));
System.out.println("second = " + calendar.get(Calendar.SECOND));

设置一个值给制定的字段 年月日时分秒
calendar.set(Calendar.YEAR, 2088);

设置一个值给制定的指端，用来增加和减少 年月日时分秒
可以是增加或是减少
calendar.add(Calendar.YEAR, -100);

把日历对象转换成日期对象
Date date5 = calendar.getTime();
-----
## System类
#### System.currentTimeMillis();
返回以毫秒值为单位的当前时间，可以用来获取一个操作使用的时间

#### System.arrayCopy(src 要复制的原数组，secpos 原数组的起始索引位置， dest 目标数组，destpos 目标数组的起始索引位置， length 要复制的数组元素的数量);
```
int[] src = {1, 2, 3, 4, 5};
int[] dest = {6, 7, 8, 9 , 10};
System.out.println("复制前：" + Arrays.toString(dest)); // [6, 7, 8, 9, 10]
System.arraycopy(src, 0 , dest, 0, 3);
System.out.println("复制后：" + Arrays.toString(dest)); [1, 2, 3, 9, 10]
```








