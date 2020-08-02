package lambda;

/*
* 通过对象名引用成员方法
* 使用前提是对象名已经存在，成员方法也已经存在，就可以使用对象名来引用成员方法
* */
public class test03 {
    public static void printString(Printable printable) {
        printable.print("sb");
    }

    public static void main(String[] args) {
        printString( s -> {
            MethodRefObject methodRefObject = new MethodRefObject();
            methodRefObject.printUpperCase(s);
        });


        // 方法引用优化Lambda
        MethodRefObject methodRefObject = new MethodRefObject();
        printString(methodRefObject::printUpperCase);
    }
}
