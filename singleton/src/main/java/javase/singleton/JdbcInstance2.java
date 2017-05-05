package javase.singleton;

/**
 * 通过枚举 JDK5.0后支持
 * Created by wangzhiping on 17/5/3.
 */
public enum JdbcInstance2 {

    INSTANCE2(),
    INSTANCE();


    private JdbcInstance2(){}

    public static void main(String[] args) {
        JdbcInstance2 instance1 = INSTANCE;
        JdbcInstance2 instance2 = INSTANCE;

        assert instance1 == instance2;

        // 缺点就是可以有多个实例，每个实例实际就是枚举实例
        JdbcInstance2 instance3 = INSTANCE2;
        JdbcInstance2 instance4 = INSTANCE;

        assert instance3 != instance4;

    }
}
