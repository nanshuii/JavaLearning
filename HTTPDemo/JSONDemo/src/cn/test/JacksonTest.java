package cn.test;

import cn.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {

    @Test
    public void test1() {
        // 创建一个java对象
        Person p = new Person();
        p.setName("name1");
        p.setAge(12);
        p.setGender("男");
        p.setBirthday(new Date());

        // 创建Jackson核心对象
        ObjectMapper mapper = new ObjectMapper();

        // 转换
        String json = null;
        try {
            json = mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // {"name":"name1","age":12,"gender":"男"}
        System.out.println(json);
    }

    @Test
    public void test2() {
        Person p1 = new Person();
        p1.setName("name1");
        p1.setAge(12);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("name2");
        p2.setAge(12);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("name3");
        p3.setAge(12);
        p3.setGender("男");
        p3.setBirthday(new Date());

        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // [{"name":"name1","age":12,"gender":"男","birthday":"2020-08-12"},
        // {"name":"name2","age":12,"gender":"男","birthday":"2020-08-12"},
        // {"name":"name3","age":12,"gender":"男","birthday":"2020-08-12"}]
        System.out.println(json);
    }

    @Test
    public void test3() {
        String json = "{\"name\":\"name1\",\"age\":12,\"gender\":\"男\"}";
        ObjectMapper mapper = new ObjectMapper();
        Person p = null;
        try {
            p = mapper.readValue(json, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(p);
    }

}
