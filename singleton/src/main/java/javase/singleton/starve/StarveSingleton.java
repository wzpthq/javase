package javase.singleton.starve;

/**
 * 饿汉模式，
 * Created by wangzhiping on 17/5/3.
 */
public class StarveSingleton {

    private static final StarveSingleton instance = new StarveSingleton();

    private StarveSingleton(){}

    public static StarveSingleton getInstance(){
        return instance;
    }

}
