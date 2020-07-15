package lambda;

/*
* 通过this引用成员方法
* */
public class test07 {
    public void method(Greetable greetable) {
        greetable.greet();
    }

    public void print() {
        System.out.println("好无聊啊");
    }

    public void printMethod() {
        method( () -> {
            this.print();
        });

        method(this::print);
    }

    public static void main(String[] args) {
        new test07().printMethod();
    }
}
