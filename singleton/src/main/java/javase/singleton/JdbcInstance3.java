package javase.singleton;

/**
 * Created by wangzhiping on 17/5/3.
 */
public class JdbcInstance3 {

    private JdbcInstance3(){}

    private static class JdbcInstance3Handler {
        private static JdbcInstance3 instance = new JdbcInstance3();
    }

    public static JdbcInstance3 getInstance(){
        return JdbcInstance3Handler.instance;
    }

    public static void main(String[] args) {
        assert getInstance() == getInstance();
    }
}
