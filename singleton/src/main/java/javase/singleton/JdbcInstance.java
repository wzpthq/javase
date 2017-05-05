package javase.singleton;

/**
 * 饿汉实现
 * Created by wangzhiping on 17/5/3.
 */
public class JdbcInstance {

    private static JdbcInstance instance = new JdbcInstance();

    private JdbcInstance(){}

    public static JdbcInstance getInstance(){
        return instance;
    }


    public static void main(String[] args) {

        JdbcInstance instance1 = getInstance();
        JdbcInstance instance2 = getInstance();

        assert instance1 == instance2;
    }
}
