package streamtest;

import java.util.stream.Stream;

/*
* 延迟方法：返回值类型仍然是Stream接口自身类型的方法，支持链式调用
*
*   filter
*   Stream<T> filter(Predicate<? super T> predicate);
*   接收一个Predicate函数式接口参数（可以是一个Lambda或方法引用）作为筛选条件
*
*   map
*   <R> Stream<R> map(Function<? super T, ? extends R> mapper);
*   需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流
*
*   limit
*   Stream<T> limit(long maxSize);
*   截取前n个
*
*   skip
*   Stream<T> skit(long n);
*   跳过前n个，n大于流长度则返回长度为0的空流
*
*   concat
*   static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
*   静态方法，合并两个流成为一个流
*
*
* 终结方法：返回值类型不再是Stream接口自身类型的方法
*
*   count
*   返回一个long类型代表个数
*
*   forEach
*   void forEach(Consumer<? super T> action);
*   接收一个Consumer接口函数，会将每一个流元素交给该函数进行处理
* */
public class test03 {
    public static void main(String[] args) {
        fun01();
        fun02();
        fun03();
        fun04();
        fun05();
        fun06();
        fun07();
    }

    public static void fun01() {
        System.out.println("\r\n ----forEach----");
        Stream<String> stringStream = Stream.of("张无忌", "张三丰", "周芷若");
        stringStream.forEach((name -> System.out.println(name)));
    }

    public static void fun02() {
        System.out.println("\r\n ----filter----");
        Stream<String> stringStream = Stream.of("张无忌", "张三丰", "周芷若");
        stringStream.filter((String name) -> {
            return name.startsWith("张");
        }).forEach(name -> System.out.println(name));
    }

    public static void fun03() {
        System.out.println("\r\n ----map----");
        Stream<String> stringStream = Stream.of("1", "2", "3");
        stringStream.map((String s) -> {
           return Integer.parseInt(s);
        }).forEach(i -> System.out.println(i));
    }

    public static void fun04() {
        System.out.println("\r\n ----count----");
        Stream<String> stringStream = Stream.of("1", "2", "3");
        System.out.println(stringStream.count());
    }

    public static void fun05() {
        System.out.println("\r\n ----limit----");
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");
        stringStream.limit(3).forEach(i -> System.out.println(i));
    }

    public static void fun06() {
        System.out.println("\r\n ----skit----");
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");
        stringStream.skip(2).forEach(i -> System.out.println(i));
    }

    public static void fun07() {
        System.out.println("\r\n ----concat----");
        Stream<String> stringStream1 = Stream.of("1", "2");
        Stream<String> stringStream2 = Stream.of("3", "4", "5");
        Stream.concat(stringStream1, stringStream2)
                .forEach(name -> System.out.println(name));
    }
}
