package lambda;

/*
* 通过类名引用静态成员方法
* 类已经存在，静态成员方法也存在
*
* */
public class test04 {
    public static int method(int number, Calcable calcable) {
        return calcable.calsAbs(number);
    }

    public static void main(String[] args) {
        // normal
        method(-10, (n) -> {
            return Math.abs(n);
        });

        // 通过类名引用静态成员方法
        // Math类存在，abs计算绝对值静态方法也已经存在
        method(-10, Math::abs);
    }
}
