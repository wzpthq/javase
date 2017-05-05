package javase.singleton.enums;

/**
 * 枚举实现单例，不仅没有并发问题，同时也可以防止反射问题问题
 * Created by wangzhiping on 17/5/3.
 */
public enum EnumSingleton {

    INSTANCE();

    private EnumSingleton(){}

}
