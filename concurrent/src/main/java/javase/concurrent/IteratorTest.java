package javase.concurrent;

import org.junit.Test;

import java.util.*;

/**
 * Created by wangzhiping on 17/5/2.
 */
public class IteratorTest {

    @Test
    public void testModifyIterator(){

        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());
        nums.add(1);
        nums.add(2);

//        for (int i = 0; i < nums.size(); i ++) {
//            nums.remove(i);
//        }
        for(Iterator<Integer> i = nums.iterator(); i.hasNext(); ){
            nums.remove(i.next());
        }

    }
}

