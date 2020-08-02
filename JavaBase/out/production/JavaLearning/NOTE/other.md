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
#### StringBuilder类
#### Iterator 迭代器
#### Map
#### lambda表达式
#### File类
#### 字节输出
#### 字节输入
#### 字符输入
#### 字符输出
#### Properties属性集

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
add可以指定替换某个index的值

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
----
## StringBuilder类
字符串是常量，在创建之后不可改变；进行字符串的相加，内存中会产生多个字符串，效率低下
StringBuilder是字符串缓冲区，是一个可以变化的字符串，实际上是一个数组，初始长度为16
byte[] value = new byte[16];

#### 初始化
StringBuilder sb1 = new StringBuilder();
StringBuilder sb2 = new StringBuilder("11231232131231231231231231");

#### 常用方法
append(任意类型) 返回StringBuilder
toString() 转换成String
-----
## Iterator 迭代器
Collection集合元素的通用获取方式，获取元素时候判断集合中是否还有元素

#### 初始化
迭代器的泛型和集合泛型相同
Iterator<String> iterator = collection.iterator();

#### 常用方法
hasNext()
返回true，则有下一个元素

next()
返回迭代器的下一个元素

```$xslt
Collection<String> collection = new ArrayList<String>();
collection.add("1");
collection.add("2");
collection.add("3");
collection.add("4");
System.out.println(collection);

Iterator<String> iterator = collection.iterator();
while (iterator.hasNext()) {
    String str = iterator.next();
    System.out.println(str);
}
```
------
----
---
## 可变参数
当数据类型一致的时候，相当于传递了一个数组
可变参数必须放在参数列表最后面
#### 实例
```
test024(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
test025("hhhh", 1.11, 1, 2, 3);

public static void test024(int ...arr) {
    System.out.println(Arrays.toString(arr));
    int num = 0;
    for (int i : arr) {
        num += i;
    }
    System.out.println(num);
    }
    
public static void test025(String a, Double b, int ...arr) {
    System.out.println(a);
    System.out.println(b);
    System.out.println(Arrays.toString(arr));
    }
```
-----
## Map
HashMap 无序 key-value可以是null
LinkedHashMap 有序

#### 初始化
Map<String, String> map = new HashMap<>();

#### 常用方法
##### put
当key不存在的时候，新建key-value；返回null
当key存在的时候，替换value；返回被替换的value

##### remove
当key不存在的时候，返回null
当key存在的时候，返回被移除的value

##### get
当key不存在的时候，返回null
当key存在的时候，返回value

##### containsKey
返回boolean

##### keySet
返回一个set<T> set key

#### Entry<key, value> 键值对对象
entrySet 获取set entry
Set<Map.Entry<String, String>> set = map.entrySet();
----
## lambda表达式
#### 由三部分组成：
一些参数，一个箭头，一段代码
(参数列表) -> {一段代码}

> ()接口中抽象方法的参数列表，没有就空，多个参数用逗号分割
> -> 参数传递
> {} 方法体

#### 可推导可省略
凡是根据上下文推导出来的内容，都可以省略书写；
1. (参数列表)：括号中参数列表的数据类型可以省略；括号中的参数如果只有一个，那么类型和括号都可以省略；
2. {一些代码}：大括号中的代码只有一行，无论是否有返回值，都可以省略 {}、return、分号，必须一起省略；
----
## File类
#### 创建一个文件实例
new File(String pathname)
new File(File parent, String child)
new File(String parent, String child)

#### 路径
##### 路径分隔符
File.pathSeparator 返回String类型
File.pathSeparatorChar 返回Char类型
> windows分号; linux冒号:
##### 文件名称分隔符
File.separator
File.separatorChar
> windows反斜杠\ linux正斜杠/

> 路径不区分大小写
> windows分隔符使用反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠
> 绝对路径 一个完整的路径
> 相对路径 一个简化的路径

#### 获取路径
getAbsolutePath() 获取绝对路径
getPath() 获取相对路径
toString() 相当于getPath()
getName() 文件路径的结尾部分，文件/文件夹
length() long类型，文件大小，以字节为单位；文件夹没有大小，为0；文件路径不存在，大小为0；
exists() 路径是否存在
isDirectory() 是否是目录
isFile() 是否是文件

#### 创建文件或目录
createNewFile() 返回boolean
new File一个文件地址 有一个IOException异常
只能创建不存在文件
如果创建的时候文件路径中的目录不存在，那么会抛出异常

mkdir() 返回boolean
new File一个文件夹地址
只能创建不存在的单级文件夹

mkdir() 返回boolean
new File一个文件夹地址
只能创建不存在的单级/多级文件夹

#### 删除文件或目录
delete() 返回boolean
直接硬盘删除文件/文件夹，不进回收站
文件夹里面有内容，删除不成功

#### 遍历文件目录
list() 返回String字符串数组
返回目录下的文件/文件夹
如果是不存在的目录，或者是文件，则返回null

listFiles() 返回File对象数组
返回目录下的文件/文件夹
如果是不存在的目录，或者是文件，则返回null
-----
## 字节输出
#### OutputStream()
public void close()
关闭此输出流并释放与此流相关联的任何系统资源

public void flush()
刷新此输出流并强制任何缓冲的输出字节被写出

public void write(byte[] b)
将b.length字节从指定的字节数组写入此输出流
如果写入的byte数组中第一个字节是正数（0-127），那么显示的时候会调用ASCII表
如果写入的byte数组中第一个字节是负数，第一个字节会和第二个字节组合成一个中文，显示的时候调用系统码表

public void write(byte[] b, int off, int len)
从指定的字节数组写入len字节，从偏移量off开始输出到此输出流

public void abstract void write(int b)
将指定的字节输出流
#### 文件字节输出流
FileOutputStream extends OutputStream
把内存中的数据写入到硬盘的文件中

构造方法：
FileOutputStream(String name)
创建一个向具有指定名称的文件中写入数据的输出文件流

FileOutputStream(File file)
创建一个向指定File对象表示的文件中写入数据的文件输出流

FileOutputStream(String name, boolean append)
创建一个向具有指定name的文件中写入数据的输出文件夹流
append true 创建对象不会覆盖原文件，继续在文件的末尾追加写数据
append false 创建对象会覆盖原文件

FileOutputStream(File file, boolean append)
创建一个向指定File对象表示的文件中写入数据的文件输出流
append true 创建对象不会覆盖原文件，继续在文件的末尾追加写数据
append false 创建对象会覆盖原文件
#### 换行符号
windows \r\n
linux \n
mac \r

-------
## 字节输入
#### InputStream()
public int read()
从输入流中读取数据的下一个字节
读取到文件的末尾返回-1

public int read(byte[] b)
从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
一般byte数组存储1024倍数的长度，1kb
int 返回的是byte数组中的真实字节数量
可以使用String类型的构造把读取的字节转换成String
String string = new String(bytes, 0, len);

public void close()
关闭此输入流并释放与该流关联的所有系统资源

#### 文件字节输入流
FileInputStream extends InputStream 
把硬盘文件中的数据，读取到内存中使用

构造方法
FileInputStream(String name)
FileInputStream(File file)

----
## 字符输入
#### Reader()
public int read()
读取单个字符
读取到文件的末尾返回-1

public int read(char[] cbuf)
读取多个字符进入数组

public void close()
关闭释放文件资源

#### 文件字符输入流
FileReader() extends InputStreamReader extends Reader
把硬盘文件中的数据以字符的方式读取到内存中

构造方法
FileReader(String filename)
FileReader(File file)

---
## 字符输出
#### Writer()
public void write(int c) 写入字符
public void write(char[] cbuf) 写入字符数组
public abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分，off 数组的开始索引，len 写的字符个数
public void write(String string) 写入字符串
public void write(String string, int off, int len) 写入字符串的某一部分，off 字符串的开始索引，len 写的字符个数
public void flush() 刷新该流的缓存
public void close() 关闭此流，但要先刷新

#### 文件字符输出流
FileWriter() extends OutputStreamWriter extends Writer
把内存中的字符写入到文件夹中

构造方法
FileWriter(String filename)
FileWriter(File file)
写入的时候是写入到内存缓冲区，写完之后flush，也可以是直接close（也做了刷新操作）
----
## Properties属性集
#### Properties extends Hashtable<k, v> implements Map<k, v>
一个持久的属性集，可保存在流中或从流中加载
属性列表中每个键及其对应值都是一个字符串；

#### 唯一和IO流相结合的集合
可以使用Properties中的store，将集合中的临时数据持久化写入到硬盘中存储；
可以使用Properties中的load，将硬盘中保存的文件读取到集合中使用

#### get set
Object setProperty(String key, String value)
String getProperty(String key)
Set<String> stringPropertyNames()

#### 持久化存储
store()时候需要一个输出流
可以是OutputStream out 字节输出流，不能写入中文（默认Unicode编码）
可以是Writer writer 字符输出流，可以写入中文
然后是String Comments注释，默认Unicode编码，一般不使用中文，使用空字符串
```$xslt
Properties properties = new Properties();
properties.setProperty("11111", "1-value");
properties.setProperty("22222", "2-value");
properties.setProperty("33333", "3-value");

Set<String> keys = properties.stringPropertyNames();
for (String key : keys) {
    System.out.println(properties.getProperty(key));
}
FileWriter fileWriter = new FileWriter("com/test/demo/test06.txt");
properties.store(fileWriter, "save commit");
fileWriter.close();
```

#### 持久化读取
load()时候需要一个输入流
可以是InputStream 字节输入流，不能读取中文
可以是Reader 字符输入流，可以读取中文
```$xslt
Properties properties = new Properties();
FileReader fileReader = new FileReader("com/test/demo/test06.txt");
properties.load(fileReader);
Set<String> keys = properties.stringPropertyNames();
for (String key : keys) {
    System.out.println(properties.getProperty(key));
}
```




