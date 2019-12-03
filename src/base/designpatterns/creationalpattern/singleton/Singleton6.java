package base.designpatterns.creationalpattern.singleton;

/**
 * @author liyu
 * @date 2019/12/3 11:22
 * @description 实现单例模式的最佳方法
 * 简洁，自动支持序列化机制，绝对防止多次实例化 （如果单例类实现了Serializable接口，默认情况下每次反序列化总会创建一个新的实例对象
 */
public enum  Singleton6 {
    //定义一个枚举的元素，它就是 Singleton 的一个实例
    INSTANCE;

    public void doSomeThing() {
        System.out.println("枚举方法实现单例");
    }
}
