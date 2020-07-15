package lambda;

public class test09 {
    public static int[] createArray(int length, ArrayBuilder arrayBuilder) {
        return arrayBuilder.builderArray(length);
    }

    public static void main(String[] args) {
        int[] arr1 = createArray(10, length -> {
            return new int[length];
        });
        System.out.println(arr1.length);

        // 数组长度已知 10
        // 数组方法已知 new
        // 数组类型已知 int[]
        int[] arr2 = createArray(10, int[]::new);
        System.out.println(arr2.length);
    }
}
