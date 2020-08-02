package streamtest;
import java.util.*;
import java.util.stream.Stream;

/*
* java.util.stream<T>是Java 8新加入的最常用的流接口。（并不是一个函数接口）
* 获取流的方式：
*   1。所有的Collection集合都可以通过stream默认方法获取流；
*       default Stream<E> stream()
*   2。Stream接口的静态方法of可以获取数组对应的流
*       static <T> Stream<T> of (T... value)
*       参数是一个可变参数，那么我们就可以传递一个数组
* */
public class test02 {
    // 集合 to Stream
    List<String> list = new ArrayList<>();
    Stream<String> stream1 = list.stream();

    Set<String> set = new HashSet<>();
    Stream<String> stream2 = set.stream();

    Map<String, String> map = new HashMap<>();

    Set<String> keySet = map.keySet();
    Stream<String> stream3 = keySet.stream();

    Collection<String> collection = map.values();
    Stream<String> stream4 = collection.stream();

    Set<Map.Entry<String, String>> entries = map.entrySet();
    Stream<Map.Entry<String, String>> stream5 = entries.stream();

    // 数组 to stream
    Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);

    Integer[] arr = {1, 2, 3, 4, 5};
    Stream<Integer> stream7 = Stream.of(arr);
}
