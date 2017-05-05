package javase.execption.sample;

import javase.exception.exceptions.UserException;
import org.junit.Test;

/**
 * Created by wangzhiping on 17/5/3.
 */
public class CheckedExceptionTest {

    public static String login(String username, String password) throws UserException {
        if (username.equals("admin") && password.equals("admin")){
            return username + " : " + password;
        }

        throw new UserException();
    }

    // 检查性异常，通过继承于Exception，需要代码catch
    @Test
    public void testUserException() {
        // UserException 是检查性异常，需要显示的进行catch
        try {
            login("wangzhiping", "wangzhiping");
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

}
