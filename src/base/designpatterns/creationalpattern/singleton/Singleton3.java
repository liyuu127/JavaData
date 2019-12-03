package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 10:23
 * @description
 * 序中每次使用getInstance() 都要经过synchronized加锁这一层，这难免会增加getInstance()的方法的时间消费，而且还可能会发生阻塞
 */
public class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    //没有加入synchronized关键字的版本是线程不安全的
    public static synchronized Singleton3 getSingletion3() {
        //判断当前单例是否已经存在，若存在则返回，不存在则再建立单例
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
