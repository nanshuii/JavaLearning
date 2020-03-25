## 目录
#### Java内存
#### 类型转换
#### 方法
#### 数组
#### 局部变量和全局变量
#### interface接口
----
## java内存
#### 栈Stack
存放的都是方法中的局部变量，方法的运行一定要在栈当中。
局部变量：方法的参数，或者是方法{}内部的变量。
作用域：一旦超出作用域，立刻从栈中消失。

#### 堆Heap
凡是new出来的东西，都在堆当中。
堆内存里面的东西都有一个地址值：16进制。
堆内存里面的数据都有默认值：
整数 0
浮点数 0.0
字符 '\u0000'
布尔 false
引用类型 null

#### 方法区Method Area
存储.class相关信息，包含方法的信息。

#### 本地方法栈Native Method Stack
与操作系统相关。

#### 寄存器pc Register
与CPU相关


---
## 类型转换
#### 自动类型转换，隐式转换
需要范围从小到大，比如int-->long类型
long num = 100;
范围从大到小不允许
#### 强制类型转换
有可能精度损失，数据溢出
比如 int-->long
int num = (int)600000000000000001L
#### byte/short/char计算
都可以使用数学运算，比如+
在进行运算的时候，会首先转换为int再计算
byte1 + byte2 --> int1 + int2
int num = byte1 + byte2

---
## 方法
#### 格式
public static void 方法名称() {
    方法体
}
比如:
public static void function1() {
    System.out.println("hi");
}
#### 方法的重载
> 参数个数不同
> 参数类型不同
> 参数多类型顺序不同
> 与返回值类型不相关
###### 示例
public static int sum(int a, int b) {
    return a + b;
}

public static int sum(int a, int b, int c) {
    return a + b + c;
}

public static int sum(int a, int b, int c, int d) {
    return a + b + c + d;
}

###### 调用的时候
System.out.println(sum(1 ,2));
System.out.println(sum(1, 2, 3));
System.out.println(sum(1, 2, 3, 4));

---
## 数组
#### 动态初始化
###### 数据类型[] = new 数据类型[长度]
创建一个300长度的int类型
int[] array = new int[300];
#### 静态初始化
###### 数据类型[] 数组名称 = new 数据类型[] {元素1， 元素2， ……}
int[] array = new int[] {1, 2, 3};
String[] array = new String[] {"1", "2", "3"};
###### 数据类型[] 数组名称 = {元素1， 元素2……}
int[] array = {"1", "2", "3"};

---
## 局部变量和全局变量
#### 内存
局部变量位于栈内存
全局变量位于堆内存、
#### 初始化赋值
局部变量需要赋值才能勇
全局变量不需要赋值
#### 局部变量和类成员类变量重名时候
就近原则，优先使用局部变量

----
## interface接口
## 定义
public interface 接口名称{ //...... }
没有static静态代码块，没有构造方法
一个类可以同时实现多个接口
一个类的父类和接口方法重名，优先使用父类中的方法
#### 不同版本java下接口内容：
java7
常量 抽象方法

java8
默认方法 静态变量

java9
私有方法

#### 接口的使用
由实现类来实现该接口 public class 实现类名称 implements 接口名称 { //...... }
需要覆盖重写接口中的抽象方法

#### 默认方法
public default 返回值类型 方法名称() { //......}
接口中的默认方法可以解决接口的升级问题

#### 静态方法
public static 返回值名称 方法名称() { // ...... }
不可以通过实现类的对象来调用静态方法，直接接口类调用

#### 私有方法
普通私有方法用来解决多个默认方法之间重复代码的问题 private 返回值类型 方法名称(){ //...... }
静态私有方法用来解决多个静态方法之间重复代码的问题 private static 返回值类型 方法名称(){ //...... }

#### 成员变量
public static final 三个关键字进行修饰，相当于常量，不可修改
使用全大写 使用下划线进行分布


