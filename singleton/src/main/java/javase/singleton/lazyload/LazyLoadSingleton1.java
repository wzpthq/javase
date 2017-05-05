package javase.singleton.lazyload;

/**
 * 为了面对饿汉的缺陷，我们可以提供懒汉模式来延迟加载
 * Created by wangzhiping on 17/5/3.
 */
public class LazyLoadSingleton1 {

    private static LazyLoadSingleton1 instance = null;

    private LazyLoadSingleton1(){}

    // 只适合在单线程模型是存在并发问题
    public static LazyLoadSingleton1 getInstance(){
        if (instance == null){
            instance = new LazyLoadSingleton1();
        }
        return instance;
    }
}
