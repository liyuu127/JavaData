package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 10:21
 * @description 懒汉式（非线程安全和synchronized关键字线程安全版本 ）
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {
    }

    //没有加入synchronized关键字的版本是线程不安全的
    public static Singleton2 getSingleton2() {
        //判断当前单例是否已经存在，若存在则返回，不存在则再建立单例
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
