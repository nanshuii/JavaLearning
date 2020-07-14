package lambda;


/*
* 使用Lambda优化日志案例
* Lambda的特点是延迟加载，使用的前提是必须存在函数式接口
*
* */
public class testLogLamdba {
    public static void showLog(int level, testLogLambdaInterface testLogLambdaInterface) {
        if (level == 1) {
            System.out.println(testLogLambdaInterface.buildMessage());
        }
    }

    public static void main(String[] args) {
        String msg1 = "111";
        String msg2 = "222";
        String msg3 = "333";
        /*
        * 使用Lambda表达式作为参数传递，仅仅是把参数传递到showLog()方法中
        * 只有满足条件 level=1，才会调用buildMessage
        *
        * 如果不满足条件 level!=1，不会执行buildMessage
        *
        * */
        showLog(2, () -> {
            return msg1 + msg2 + msg3;
        });
    }
}
