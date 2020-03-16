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

## 方法
#### 格式
public static void 方法名称() {
    方法体
}
