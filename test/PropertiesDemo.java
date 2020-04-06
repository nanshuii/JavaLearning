package test;

/*
* Properties属性集
* Properties extends Hashtable<k, v> implements Map<k, v>
* 一个持久的属性集，可保存在流中或从流中加载；属性列表中每个键及其对应值都是一个字符串；
*
* 唯一和IO流相结合的集合
* 可以使用Properties中的store，将集合中的临时数据持久化写入到硬盘中存储；
* 可以使用Properties中的load，将硬盘中保存的文件读取到集合中使用
*
* Object setProperty(String key, String value)
* String getProperty(String key)
* Set<String> stringPropertyNames()
*
* 持久化存储
* store()时候需要一个输出流
* 可以是OutputStream out 字节输出流，不能写入中文（默认Unicode编码）
* 可以是Writer writer 字符输出流，可以写入中文
* 然后是String Comments注释，默认Unicode编码，一般不使用中文，使用空字符串
*
* 持久化读取
* load()时候需要一个输入流
* 可以是InputStream 字节输入流，不能读取中文
* 可以是Reader 字符输入流，可以读取中文
*
* */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        test02();
    }

    public static void test01() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("11111", "1-value");
        properties.setProperty("22222", "2-value");
        properties.setProperty("33333", "3-value");

        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(properties.getProperty(key));
        }

        // 持久化存储
        FileWriter fileWriter = new FileWriter("com/test/demo/test06.txt");
        properties.store(fileWriter, "save commit");
        fileWriter.close();
    }

    public static void test02() throws IOException {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("com/test/demo/test06.txt");
        properties.load(fileReader);
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(properties.getProperty(key));
        }
    }
}
