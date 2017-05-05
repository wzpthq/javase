package javase.singleton;

import org.junit.Test;

/**
 * Created by wangzhiping on 17/5/3.
 */
public class JdbcInstance1 {

    private static JdbcInstance1 instance1 = null;

    private JdbcInstance1(){}

    public static JdbcInstance1 getInstance(){
        if (instance1 == null){ // 并发点
            instance1 = new JdbcInstance1();
        }

        return instance1;
    }

    public static void main(String[] args){
        /**
         * 如果是单线程执行没有问题，出现多线程情况就会有并发问题；
         * 缺点就是存在并发性问题，需要做协同操作
         */
        JdbcInstance1 instance1 = getInstance();
        JdbcInstance1 instance2 = getInstance();

        assert instance1 == instance2;
    }
}
