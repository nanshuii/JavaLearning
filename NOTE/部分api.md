## 目录
#### Scanner键盘输入

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