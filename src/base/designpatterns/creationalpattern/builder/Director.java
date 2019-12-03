package base.designpatterns.creationalpattern.builder;

/**
 * @author liyu
 * @date 2019/12/3 15:00
 * @description Director（指挥者）：构建一个使用Builder接口的对象。它主要是用于创建一个复杂的对象。它主要有两个作用，一是：隔离了客户与对象的生产过程，二是：负责控制产品对象的生产过程
 */
public class Director {
    private Builder builder;

    //1 构造方法的方式注入builder对象
    public Director(Builder builder) {
        this.builder = builder;
    }

    //2 set方法注入builder对象
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
