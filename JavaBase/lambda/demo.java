package lambda;


/*
* 函数式接口的使用：一般可以作为方法的参数和返回值类型
* */
public class demo {
    // 定义一个方法，参数使用函数式接口的实现类对象
    public static void show(MyFunctionalInterface myFunctionalInterface){
        myFunctionalInterface.method();
    }

    public static void main(String[] args) {
        // show方法参数是一个接口，可以传递参数的实现类对象
        show(new MyFunctionalInterfaceImpl());

        // show方法参数是一个接口，可以传递参数的匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        // show方法参数是一个接口，可以传递Lambda
        show(() -> {
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });

        show(() -> System.out.println("使用简化的Lambda表达式重写接口中的抽象方法"));
    }
}
