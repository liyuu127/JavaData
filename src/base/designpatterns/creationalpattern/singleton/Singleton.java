package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 10:17
 * @description 饿汉式(线程安全）
 * JVM在加载这个类时就马上创建此唯一的单例实例，如果一直没有被使用，浪费了空间，典型的空间换时间，每次调用的时候，不需要再判断，节省了运行时间。
 */
public class Singleton {
    //在静态初始化器中创建单例实例，这段代码保证了线程安全
    private static Singleton singleton = new Singleton();

    //Singleton类只有一个构造方法并且是被private修饰的，所以用户无法通过new方法创建该对象实例
    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
