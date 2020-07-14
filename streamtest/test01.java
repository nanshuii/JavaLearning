package streamtest;
import java.util.ArrayList;
import java.util.List;

public class test01 {
    public static void main(String[] args) {
        traverse();
    }

    public static void traverse() {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三丰");
        list.add("张san");
        list.add("英梨梨");

        // 传统遍历
        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }

        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                shortList.add(name);
            }
        }

        for (String name : shortList) {
            System.out.println(name);
        }

        // Stream流方式
        list.stream().filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(name -> System.out.println(name));

    }
}


