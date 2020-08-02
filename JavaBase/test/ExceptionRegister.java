package test;

/*
* 自定义异常类
* 继承Exception或者RuntimeException
*
*
* */
public class ExceptionRegister extends Exception{

    public ExceptionRegister() {
        super();
    }

    public ExceptionRegister(String message) {
        super(message);
    }
}
