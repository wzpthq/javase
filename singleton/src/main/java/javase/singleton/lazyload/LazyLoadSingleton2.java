package javase.singleton.lazyload;

/**
 * 为了面对饿汉的缺陷，我们可以提供懒汉模式来延迟加载
 * Created by wangzhiping on 17/5/3.
 */
public class LazyLoadSingleton2 {

    private static LazyLoadSingleton2 instance = null;

    private LazyLoadSingleton2(){}

    // 同步锁方法级别或者，但是这样处理在并发条件下性能不是很好
    public static synchronized LazyLoadSingleton2 getInstance(){
        if (instance == null){
            instance = new LazyLoadSingleton2();
        }
        return instance;
    }

    // 这两种同步基本没啥差别
//    public static  LazyLoadSingleton2 getInstance(){
//
//        synchronized(LazyLoadSingleton2.class){
//            if (instance == null){
//                instance = new LazyLoadSingleton2();
//            }
//        }
//
//        return instance;
//    }
}
