package base.designpatterns.creationalpattern.prototype;

import java.util.HashMap;

/**
 * @author liyu
 * @date 2019/12/4 9:51
 * @description Manager类使用Product接口来复制实例。
 * Product接口以及Manager类的代码完全没有出现在MessageBox类和UnderlinePen类的名字，
 * 因此这意味着我们可以独立地修改Product接口以及Manager类，不受MessageBox类和UnderlinePen类的影响。
 * 这是非常重要的，因为 一旦在类中使用到了别的类名，就意味着该类与其他类紧密的地耦合在了一起 。
 * 在Manager类中，并没有写明具体的类名， 仅仅使用了Product这个接口名。也就是说，Product接口成为了连接Manager类与其他具体类之间的桥梁。
 */

public class Manager {
    //保存实例的“名字”和“实例”之间的对应关系
    private HashMap<String, Product> showcase = new HashMap<String, Product>();

    //register方法将接收到的一组“名字”和“Product接口”注册到showcase中。这里Product是实现Product接口的实例，具体还未确定
    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String productName) {
        Product p = showcase.get(productName);
        return p.creatClone();
    }

}
