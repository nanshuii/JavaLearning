package lambda;

@FunctionalInterface
public interface testLogLambdaInterface {
    // 定义一个拼接消息的抽象方法，返回被拼接的消息
    public abstract String buildMessage();
}
