package javase.singleton.starve;

/**
 * Created by wangzhiping on 17/5/3.
 */
public class StarveSingleton1 {

    private static StarveSingleton1 instance = null;

    static {
        instance = new StarveSingleton1();
    }

    private StarveSingleton1(){}

    public static StarveSingleton1 getInstance(){
        return instance;
    }
}
