package javase.execption.sample;

import org.junit.Test;

/**
 * 一般常用的非检查性异常有那些呢？
 * 例如：
 * 1、NullPointException;
 * 2、ArithmeticException;
 * 3、ArrayIndexOutOfBoundsException
 * 4、ClassNotFoundException
 * 5、IllegalArgumentException
 * ...
 * Created by wangzhiping on 17/5/3.
 */
public class UnCheckedExceptionTest {

    @Test
    public void testNumberException(){

        // ArithmeticException，继承自RuntimeException，在运行阶段，进行判断执行异常情况，
        int a = 1 / 0;
    }
}
