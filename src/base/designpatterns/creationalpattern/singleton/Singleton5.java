package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 11:20
 * @description 懒汉式（登记式/静态内部类方式)
 * 静态内部实现的单例是懒加载的且线程安全。
 * 只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance（只有第一次使用这个单例的实例的时候才加载，同时不会有线程安全问题）
 *
 * Java中静态内部类的加载时机:
 * 外部类初次加载，会初始化静态变量、静态代码块、静态方法，但不会加载内部类和静态内部类。
 * 实例化外部类，调用外部类的静态方法、静态变量，则外部类必须先进行加载，但只加载一次。
 * 直接调用静态内部类时，外部类不会加载。
 */
public class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5() {
    }

    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
