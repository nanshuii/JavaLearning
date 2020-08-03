package cn.test;

import cn.ledon.User;
import cn.ledon.UserHandle;
import org.junit.Test;

public class UserHandleTest {

    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("super");
        user.setPassword("123");
        UserHandle userHandle = new UserHandle();
        User loginUser = userHandle.login(user);
        System.out.println(loginUser);
    }
}
