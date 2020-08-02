package JunitTest;
import org.junit.jupiter.api.*;

class CalculatorTest {
    /*
    * 初始化方法，一般用于资源申请，所有测试方法在执行之前都会先执行该方法
    * */
    @BeforeEach
    public void init() {
        System.out.println("before all");
    }


    /*
    * 释放资源方法，在所有测试方法执行完后，自动执行该方法
    * */
    @AfterEach
    public void close() {
        System.out.println("after all");
    }
    

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        // 断言
        Assertions.assertEquals(3, result);
    }

    @Test
    public void testSub() {
        Calculator calculator = new Calculator();
        int result = calculator.sub(1, 2);

        // 断言
        Assertions.assertEquals(-1, result);
    }

}