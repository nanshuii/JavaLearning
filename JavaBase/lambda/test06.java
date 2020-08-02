package lambda;

/*
* test05的子类
*
* */
public class test06 extends test05{
    // 重写父类test05方法
    @Override
    public void saySB() {
        System.out.println("臭傻逼");
    }

    // method
    public static void method(Greetable greetable) {
        greetable.greet();
    }

    // show
    public void show() {
        method(()-> {
            // 创建父类对象
            test05 fa = new test05();
            fa.saySB();
        });
    }

    // super show
    public void superShow() {
        method(() -> {
            super.saySB();
        });
    }

    // super nb show
    // super已经存在；父类成员方法saySB也已经存在
    public void superNbShow() {
        method(super::saySB);
    }

    public static void main(String[] args) {
        new test06().show(); // 你是傻逼
        new test06().superShow(); // 你是傻逼
        new test06().superNbShow(); // 你是傻逼
    }
}
