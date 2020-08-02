package lambda;

/*
* 类的构造器引用（构造方法引用）
* */
public class test08 {
    // 定义一个方法，参数传递name和personBuilder接口，通过name创建person
    public static void printName(String name, personBuilder personBuilder) {
        person person = personBuilder.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        printName("傻猪", (String name) -> {
            return new person(name);
        });

        // 构造方法： new person(name) 已知
        // 创建对象的方式： new 已知
        printName("你是傻猪", person::new);
    }
}
