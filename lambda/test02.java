package lambda;

public class test02 {
    public static void main(String[] args) {
        /*
        * 调用Lambda表达式的目的是，打印参数传递的字符串
        * 把参数s传递给了System.out对象，调用out对象中的方法println对字符串进行了输出
        *   1.System.out对象已经存在的
        *   2.println方法也是已经存在
        *   可以使用方法引用来优化Lambda表达式，用System.out对象直接引用println方法
        *
        * :: 引用运算符，所在的表达式称为方法引用表达式；
        * 如果Lambda要表达的函数方法已经存在于某个方法的实现中，那么则可以通过双冒号来引用改方法作为Lambda的替代者
        * */

        printString((s)-> {
            System.out.println(s);
        });

        printString(System.out::println);
    }

    public static void printString(Printable printable) {
        printable.print("hello sb");
    }
}
