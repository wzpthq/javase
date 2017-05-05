package javase.singleton.innerstaticclass;

/**
 * 没有并发问题，推荐使用，不过可以反射创建对个对象实例
 * Created by wangzhiping on 17/5/3.
 */
public class InnerStaticClassSingleton {

    private InnerStaticClassSingleton(){}

    private static class InnerStaticClassSingletonHandler {
        private static InnerStaticClassSingleton instance = new InnerStaticClassSingleton();
    }

    public static InnerStaticClassSingleton getInstance(){
        return InnerStaticClassSingletonHandler.instance;
    }

}
