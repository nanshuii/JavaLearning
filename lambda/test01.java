package lambda;

public class test01 {
    public static void showLog(int level, String message) {
        if (level == 1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        String msg1 = "111";
        String msg2 = "222";
        String msg3 = "333";
        showLog(2, msg1 + msg2 + msg3);
    }
}
