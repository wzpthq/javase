package javase.singleton.lazyload;

/**
 * 为了面对饿汉的缺陷，我们可以提供懒汉模式来延迟加载
 * Created by wangzhiping on 17/5/3.
 */
public class LazyLoadSingleton4 {

    // 使用volatile一方面确保线程可见性，其次确保冲重排序问题，可能导致的问题
    private static volatile LazyLoadSingleton4 instance = null;

    private LazyLoadSingleton4(){}

    // 解决同步锁过重的问题，使用double-check lock来实现
    // 但是这里存在可见性问题，可能导致instance == null的情况
    public static LazyLoadSingleton4 getInstance(){
        if (instance == null){ // 两次判断的目的就是减少锁的执行，可以大大提高性能
            synchronized (LazyLoadSingleton4.class) {
                if (instance == null){
                    instance = new LazyLoadSingleton4();
                }
            }

        }
        return instance;
    }
}
