package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 11:16
 * @description 懒汉式(双重检查加锁版本)
 */
public class Singleton4 {
    private static volatile Singleton4 singleton4;

    private Singleton4() {
    }

    private Singleton4 getSingleton4() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
