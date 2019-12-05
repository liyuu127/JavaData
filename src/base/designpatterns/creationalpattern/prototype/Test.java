package base.designpatterns.creationalpattern.prototype;

/**
 * @author liyu
 * @date 2019/12/4 10:07
 * @description 首先生成Manager实例。接着，在Manager实例中通过`register方法注册了UnderlinePen类的实例（带名字）和MessageBox类的实例（带名字）
 */
public class Test {

    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("Strong message", underlinePen);
        manager.register("Waring Box", mbox);
        manager.register("Slash Box", sbox);
        Product p1 = manager.create("Strong message");
        p1.use("hello world");
        Product p2 = manager.create("Waring Box");
        p2.use("hello world");
        Product p3 = manager.create("Slash Box");
        p3.use("hello world");
    }

}
